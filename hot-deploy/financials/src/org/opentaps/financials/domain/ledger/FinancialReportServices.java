/*
 * Copyright (c) 2008 - 2009 Open Source Strategies, Inc.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the Honest Public License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Honest Public License for more details.
 *
 * You should have received a copy of the Honest Public License
 * along with this program; if not, write to Funambol,
 * 643 Bair Island Road, Suite 305 - Redwood City, CA 94063, USA
 */
package org.opentaps.financials.domain.ledger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javolution.util.FastMap;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilDateTime;
import org.ofbiz.base.util.UtilMisc;
import org.opentaps.domain.base.entities.AcctgTransAndEntries;
import org.opentaps.domain.base.entities.DataWarehouseTransform;
import org.opentaps.domain.base.entities.EncumbranceDetail;
import org.opentaps.domain.base.entities.GlAccountTransEntryFact;
import org.opentaps.domain.ledger.AccountingTransaction;
import org.opentaps.domain.ledger.EncumbranceRepositoryInterface;
import org.opentaps.domain.ledger.FinancialReportServicesInterface;
import org.opentaps.domain.ledger.GeneralLedgerAccount;
import org.opentaps.domain.ledger.LedgerException;
import org.opentaps.domain.ledger.LedgerRepositoryInterface;
import org.opentaps.domain.order.Order;
import org.opentaps.domain.order.OrderRepositoryInterface;
import org.opentaps.foundation.entity.EntityNotFoundException;
import org.opentaps.foundation.entity.hibernate.HibernateUtil;
import org.opentaps.foundation.entity.hibernate.Session;
import org.opentaps.foundation.infrastructure.InfrastructureException;
import org.opentaps.foundation.repository.RepositoryException;
import org.opentaps.foundation.service.Service;
import org.opentaps.foundation.service.ServiceException;

public class FinancialReportServices extends Service implements FinancialReportServicesInterface {

    private String organizationPartyId;
    private Timestamp startDatetime;
    private Timestamp snapshotDatetime;
    private String comments;
    private String description;

    enum FiscalType {
        ACTUAL,
        BUDGET
    }

    /** {@inheritDoc} */
    public void createGlAccountTransEntryFact() throws ServiceException {
        Session session = null;
        Transaction tx = null;

        try {

            LedgerRepositoryInterface ledgerRepository = getDomainsDirectory().getLedgerDomain().getLedgerRepository();
            OrderRepositoryInterface orderRepository = getDomainsDirectory().getOrderDomain().getOrderRepository();
            List<AcctgTransAndEntries> transactions = ledgerRepository.getPostedTransactionsAndEntries(organizationPartyId, Arrays.asList("ACTUAL", "BUDGET"), null, null);

            session = infrastructure.getSession();
            tx = session.beginTransaction();

            // clear entity first
            Query query = session.createQuery("DELETE FROM GlAccountTransEntryFact");
            query.executeUpdate();


            // look through transaction posted entries
            for (AcctgTransAndEntries trans : transactions) {
                GlAccountTransEntryFact fact = new GlAccountTransEntryFact();

                FiscalType fiscalType = null;
                if (FiscalType.ACTUAL.name().equals(trans.getGlFiscalTypeId())) {
                    fiscalType = FiscalType.ACTUAL;
                } else if (FiscalType.BUDGET.name().equals(trans.getGlFiscalTypeId())) {
                    fiscalType = FiscalType.BUDGET;
                };

                GeneralLedgerAccount glAccount = ledgerRepository.getLedgerAccount(trans.getGlAccountId(), organizationPartyId);
                boolean isDebit = "D".equals(trans.getDebitCreditFlag()) ? true : false;

                // calculate net amount
                BigDecimal netAmount = BigDecimal.ZERO;
                if (glAccount.isDebitAccount()) {
                    netAmount = isDebit ? trans.getAmount() : trans.getAmount().negate();
                } else {
                    netAmount = isDebit ? trans.getAmount().negate() : trans.getAmount();
                }

                // create instance GlAccountTransEntityFact
                fact.setAcctgTransId(trans.getAcctgTransId());
                fact.setAcctgTransEntrySeqId(trans.getAcctgTransEntrySeqId());
                fact.setTransactionDate(trans.getTransactionDate());
                fact.setOrganizationPartyId(organizationPartyId);
                fact.setGlAccountId(trans.getGlAccountId());
                if (fiscalType == FiscalType.BUDGET) {
                    fact.setBudgetDebitAmount(isDebit ? trans.getAmount() : BigDecimal.ZERO);
                    fact.setBudgetCreditAmount(!isDebit ? trans.getAmount() : BigDecimal.ZERO);
                    fact.setBudgetNetAmount(netAmount);
                    fact.setActualNetAmount(BigDecimal.ZERO);
                    fact.setActualDebitAmount(BigDecimal.ZERO);
                    fact.setActualCreditAmount(BigDecimal.ZERO);
                } else if (fiscalType == FiscalType.ACTUAL) {
                    fact.setActualDebitAmount(isDebit ? trans.getAmount() : BigDecimal.ZERO);
                    fact.setActualCreditAmount(!isDebit ? trans.getAmount() : BigDecimal.ZERO);
                    fact.setActualNetAmount(netAmount);
                    fact.setBudgetNetAmount(BigDecimal.ZERO);
                    fact.setBudgetDebitAmount(BigDecimal.ZERO);
                    fact.setBudgetCreditAmount(BigDecimal.ZERO);
                }
                fact.setEncumberedCreditAmount(BigDecimal.ZERO);
                fact.setEncumberedDebitAmount(BigDecimal.ZERO);
                fact.setEncumberedNetAmount(BigDecimal.ZERO);
                fact.setAcctgTagEnumId1(trans.getAcctgTagEnumId1());
                fact.setAcctgTagEnumId2(trans.getAcctgTagEnumId2());
                fact.setAcctgTagEnumId3(trans.getAcctgTagEnumId3());
                fact.setAcctgTagEnumId4(trans.getAcctgTagEnumId4());
                fact.setAcctgTagEnumId5(trans.getAcctgTagEnumId5());
                fact.setAcctgTagEnumId6(trans.getAcctgTagEnumId6());
                fact.setAcctgTagEnumId7(trans.getAcctgTagEnumId7());
                fact.setAcctgTagEnumId8(trans.getAcctgTagEnumId8());
                fact.setAcctgTagEnumId9(trans.getAcctgTagEnumId9());
                fact.setAcctgTagEnumId10(trans.getAcctgTagEnumId10());

                session.save(fact);
            }

            // add encumbrances
            EncumbranceRepositoryInterface encumbranceRepository = getDomainsDirectory().getLedgerDomain().getEncumbranceRepository();
            List<EncumbranceDetail> encumbrances = encumbranceRepository.getEncumbranceDetails(organizationPartyId, null, UtilDateTime.nowTimestamp());

            for (EncumbranceDetail encumb : encumbrances) {
                GlAccountTransEntryFact fact = new GlAccountTransEntryFact();

                fact.setOrganizationPartyId(organizationPartyId);
                fact.setGlAccountId(encumb.getGlAccountId());
                fact.setBudgetDebitAmount(BigDecimal.ZERO);
                fact.setBudgetCreditAmount(BigDecimal.ZERO);
                fact.setBudgetNetAmount(BigDecimal.ZERO);
                fact.setActualDebitAmount(BigDecimal.ZERO);
                fact.setActualCreditAmount(BigDecimal.ZERO);
                fact.setActualNetAmount(BigDecimal.ZERO);
                fact.setEncumberedNetAmount(encumb.getEncumberedAmount());
                fact.setEncumberedCreditAmount(BigDecimal.ZERO);
                fact.setEncumberedDebitAmount(encumb.getEncumberedAmount());
                fact.setAcctgTagEnumId1(encumb.getAcctgTagEnumId1());
                fact.setAcctgTagEnumId2(encumb.getAcctgTagEnumId2());
                fact.setAcctgTagEnumId3(encumb.getAcctgTagEnumId3());
                fact.setAcctgTagEnumId4(encumb.getAcctgTagEnumId4());
                fact.setAcctgTagEnumId5(encumb.getAcctgTagEnumId5());
                fact.setAcctgTagEnumId6(encumb.getAcctgTagEnumId6());
                fact.setAcctgTagEnumId7(encumb.getAcctgTagEnumId7());
                fact.setAcctgTagEnumId8(encumb.getAcctgTagEnumId8());
                fact.setAcctgTagEnumId9(encumb.getAcctgTagEnumId9());
                fact.setAcctgTagEnumId10(encumb.getAcctgTagEnumId10());

                // transactions with fiscal type ENCUMBRANCE
                if ("ENCUMB_MANUAL".equals(encumb.getEncumbranceDetailTypeId())) {
                    fact.setAcctgTransId(encumb.getAcctgTransId());
                    fact.setAcctgTransEntrySeqId(encumb.getAcctgTransEntryId());
                    AccountingTransaction transEntry = ledgerRepository.getAccountingTransaction(encumb.getAcctgTransId());
                    if (transEntry != null) {
                        fact.setTransactionDate(transEntry.getTransactionDate());
                    }
                }

                // purchasing orders
                if ("ENCUMB_PURCHASING".equals(encumb.getEncumbranceDetailTypeId())) {
                    fact.setOrderId(encumb.getOrderId());
                    fact.setOrderItemSeqId(encumb.getOrderItemSeqId());
                    Order order = orderRepository.getOrderById(encumb.getOrderId());
                    fact.setTransactionDate(order.getOrderDate());
                }

                session.save(fact);
            }

            session.flush();
            tx.commit();

        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        } catch (InfrastructureException e) {
            throw new ServiceException(e.getMessage());
        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new ServiceException(e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new ServiceException(e.getMessage());
        } catch (LedgerException e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public void collectEncumbranceAndTransEntryFacts() throws ServiceException {
        // create encumbrance snapshot
        Map<String, Object> context = FastMap.<String, Object>newInstance();
        context.put("userLogin", getUser().getOfbizUserLogin());
        context.putAll(
                UtilMisc.toMap(
                        "organizationPartyId", organizationPartyId,
                        "startDatetime", startDatetime,
                        "snapshotDatetime", snapshotDatetime,
                        "comments", comments,
                        "description", description
                )
        );

        runSync("createEncumbranceSnapshotAndDetail", context);

        // analyze transaction entries & encumbrance snapshot, collect summary data 
        context.clear();
        context = UtilMisc.toMap(
                "organizationPartyId", organizationPartyId,
                "userLogin", getUser().getOfbizUserLogin()
        );

        runSync("financials.createGlAccountTransEntryFact", context);

        Session session = null;
        Transaction tx = null;

        try {
            session = getInfrastructure().getSession();
            tx = session.beginTransaction();

            // create transformation runtime attributes
            DataWarehouseTransform transform = new DataWarehouseTransform();
            transform.setOrganizationPartyId(organizationPartyId);
            transform.setTransformEnumId("ENCUMB_GL_ENTRY");
            transform.setTransformTimestamp(UtilDateTime.nowTimestamp());
            transform.setUserLoginId(getUser().getUserId());
            session.save(transform);
            tx.commit();

        } catch (InfrastructureException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new ServiceException(e);
        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new ServiceException(HibernateUtil.getHibernateExceptionCause(e));
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** {@inheritDoc} */
    public void setOrganizationPartyId(String organizationPartyId) {
        this.organizationPartyId = organizationPartyId;
    }

    /** {@inheritDoc} */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /** {@inheritDoc} */
    public void setDescription(String description) {
        this.description = description;
    }

    /** {@inheritDoc} */
    public void setSnapshotDatetime(Timestamp snapshotDatetime) {
        this.snapshotDatetime = snapshotDatetime;
    }

    /** {@inheritDoc} */
    public void setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
    }

}