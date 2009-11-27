package org.opentaps.domain.base.entities;

/*
 * Copyright (c) 2008 - 2009 Open Source Strategies, Inc.
 *
 * Opentaps is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Opentaps is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Opentaps.  If not, see <http://www.gnu.org/licenses/>.
 */

// DO NOT EDIT THIS FILE!  THIS IS AUTO GENERATED AND WILL GET WRITTEN OVER PERIODICALLY WHEN THE DATA MODEL CHANGES
// EXTEND THIS CLASS INSTEAD.

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javolution.util.FastMap;

import org.opentaps.foundation.entity.Entity;
import org.opentaps.foundation.entity.EntityFieldInterface;
import org.opentaps.foundation.repository.RepositoryException;
import org.opentaps.foundation.repository.RepositoryInterface;
import javax.persistence.*;
import org.hibernate.search.annotations.*;
import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Auto generated base entity InvoiceItemAssoc.
 */
@javax.persistence.Entity
@Table(name="INVOICE_ITEM_ASSOC")
public class InvoiceItemAssoc extends Entity {
static {
java.util.Map<String, String> fields = new java.util.HashMap<String, String>();
        fields.put("invoiceItemAssocId", "INVOICE_ITEM_ASSOC_ID");
        fields.put("invoiceIdFrom", "INVOICE_ID_FROM");
        fields.put("invoiceItemSeqIdFrom", "INVOICE_ITEM_SEQ_ID_FROM");
        fields.put("invoiceIdTo", "INVOICE_ID_TO");
        fields.put("invoiceItemSeqIdTo", "INVOICE_ITEM_SEQ_ID_TO");
        fields.put("agreementId", "AGREEMENT_ID");
        fields.put("amount", "AMOUNT");
        fields.put("lastUpdatedStamp", "LAST_UPDATED_STAMP");
        fields.put("lastUpdatedTxStamp", "LAST_UPDATED_TX_STAMP");
        fields.put("createdStamp", "CREATED_STAMP");
        fields.put("createdTxStamp", "CREATED_TX_STAMP");
fieldMapColumns.put("InvoiceItemAssoc", fields);
}
  public static enum Fields implements EntityFieldInterface<InvoiceItemAssoc> {
    invoiceItemAssocId("invoiceItemAssocId"),
    invoiceIdFrom("invoiceIdFrom"),
    invoiceItemSeqIdFrom("invoiceItemSeqIdFrom"),
    invoiceIdTo("invoiceIdTo"),
    invoiceItemSeqIdTo("invoiceItemSeqIdTo"),
    agreementId("agreementId"),
    amount("amount"),
    lastUpdatedStamp("lastUpdatedStamp"),
    lastUpdatedTxStamp("lastUpdatedTxStamp"),
    createdStamp("createdStamp"),
    createdTxStamp("createdTxStamp");
    private final String fieldName;
    private Fields(String name) { fieldName = name; }
    /** {@inheritDoc} */
    public String getName() { return fieldName; }
    /** {@inheritDoc} */
    public String asc() { return fieldName + " ASC"; }
    /** {@inheritDoc} */
    public String desc() { return fieldName + " DESC"; }
  }

   @org.hibernate.annotations.GenericGenerator(name="InvoiceItemAssoc_GEN",  strategy="org.opentaps.foundation.entity.hibernate.OpentapsIdentifierGenerator")
   @GeneratedValue(generator="InvoiceItemAssoc_GEN")
   @Id
   @Column(name="INVOICE_ITEM_ASSOC_ID")
   private String invoiceItemAssocId;
   @Column(name="INVOICE_ID_FROM")
   private String invoiceIdFrom;
   @Column(name="INVOICE_ITEM_SEQ_ID_FROM")
   private String invoiceItemSeqIdFrom;
   @Column(name="INVOICE_ID_TO")
   private String invoiceIdTo;
   @Column(name="INVOICE_ITEM_SEQ_ID_TO")
   private String invoiceItemSeqIdTo;
   @Column(name="AGREEMENT_ID")
   private String agreementId;
   @Column(name="AMOUNT")
   private BigDecimal amount;
   @Column(name="LAST_UPDATED_STAMP")
   private Timestamp lastUpdatedStamp;
   @Column(name="LAST_UPDATED_TX_STAMP")
   private Timestamp lastUpdatedTxStamp;
   @Column(name="CREATED_STAMP")
   private Timestamp createdStamp;
   @Column(name="CREATED_TX_STAMP")
   private Timestamp createdTxStamp;
   private transient InvoiceItem fromInvoiceItem = null;
   private transient InvoiceItem toInvoiceItem = null;
   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
   @JoinColumn(name="AGREEMENT_ID", insertable=false, updatable=false)
   @org.hibernate.annotations.Generated(
      org.hibernate.annotations.GenerationTime.ALWAYS
   )
   
   private Agreement agreement = null;

  /**
   * Default constructor.
   */
  public InvoiceItemAssoc() {
      super();
      this.baseEntityName = "InvoiceItemAssoc";
      this.isView = false;
      
      this.primaryKeyNames = new ArrayList<String>();
      this.primaryKeyNames.add("invoiceItemAssocId");
      this.allFieldsNames = new ArrayList<String>();
      this.allFieldsNames.add("invoiceItemAssocId");this.allFieldsNames.add("invoiceIdFrom");this.allFieldsNames.add("invoiceItemSeqIdFrom");this.allFieldsNames.add("invoiceIdTo");this.allFieldsNames.add("invoiceItemSeqIdTo");this.allFieldsNames.add("agreementId");this.allFieldsNames.add("amount");this.allFieldsNames.add("lastUpdatedStamp");this.allFieldsNames.add("lastUpdatedTxStamp");this.allFieldsNames.add("createdStamp");this.allFieldsNames.add("createdTxStamp");
      this.nonPrimaryKeyNames = new ArrayList<String>();
      this.nonPrimaryKeyNames.addAll(allFieldsNames);
      this.nonPrimaryKeyNames.removeAll(primaryKeyNames);
  }

  /**
   * Constructor with a repository.
   * @param repository a <code>RepositoryInterface</code> value
   */
  public InvoiceItemAssoc(RepositoryInterface repository) {
      this();
      initRepository(repository);
  }

    /**
     * Auto generated value setter.
     * @param invoiceItemAssocId the invoiceItemAssocId to set
     */
    public void setInvoiceItemAssocId(String invoiceItemAssocId) {
        this.invoiceItemAssocId = invoiceItemAssocId;
    }
    /**
     * Auto generated value setter.
     * @param invoiceIdFrom the invoiceIdFrom to set
     */
    public void setInvoiceIdFrom(String invoiceIdFrom) {
        this.invoiceIdFrom = invoiceIdFrom;
    }
    /**
     * Auto generated value setter.
     * @param invoiceItemSeqIdFrom the invoiceItemSeqIdFrom to set
     */
    public void setInvoiceItemSeqIdFrom(String invoiceItemSeqIdFrom) {
        this.invoiceItemSeqIdFrom = invoiceItemSeqIdFrom;
    }
    /**
     * Auto generated value setter.
     * @param invoiceIdTo the invoiceIdTo to set
     */
    public void setInvoiceIdTo(String invoiceIdTo) {
        this.invoiceIdTo = invoiceIdTo;
    }
    /**
     * Auto generated value setter.
     * @param invoiceItemSeqIdTo the invoiceItemSeqIdTo to set
     */
    public void setInvoiceItemSeqIdTo(String invoiceItemSeqIdTo) {
        this.invoiceItemSeqIdTo = invoiceItemSeqIdTo;
    }
    /**
     * Auto generated value setter.
     * @param agreementId the agreementId to set
     */
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }
    /**
     * Auto generated value setter.
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    /**
     * Auto generated value setter.
     * @param lastUpdatedStamp the lastUpdatedStamp to set
     */
    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }
    /**
     * Auto generated value setter.
     * @param lastUpdatedTxStamp the lastUpdatedTxStamp to set
     */
    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }
    /**
     * Auto generated value setter.
     * @param createdStamp the createdStamp to set
     */
    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }
    /**
     * Auto generated value setter.
     * @param createdTxStamp the createdTxStamp to set
     */
    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }

    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getInvoiceItemAssocId() {
        return this.invoiceItemAssocId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getInvoiceIdFrom() {
        return this.invoiceIdFrom;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getInvoiceItemSeqIdFrom() {
        return this.invoiceItemSeqIdFrom;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getInvoiceIdTo() {
        return this.invoiceIdTo;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getInvoiceItemSeqIdTo() {
        return this.invoiceItemSeqIdTo;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getAgreementId() {
        return this.agreementId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>BigDecimal</code>
     */
    public BigDecimal getAmount() {
        return this.amount;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getLastUpdatedStamp() {
        return this.lastUpdatedStamp;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getLastUpdatedTxStamp() {
        return this.lastUpdatedTxStamp;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getCreatedStamp() {
        return this.createdStamp;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getCreatedTxStamp() {
        return this.createdTxStamp;
    }

    /**
     * Auto generated method that gets the related <code>InvoiceItem</code> by the relation named <code>FromInvoiceItem</code>.
     * @return the <code>InvoiceItem</code>
     * @throws RepositoryException if an error occurs
     */
    public InvoiceItem getFromInvoiceItem() throws RepositoryException {
        if (this.fromInvoiceItem == null) {
            this.fromInvoiceItem = getRelatedOne(InvoiceItem.class, "FromInvoiceItem");
        }
        return this.fromInvoiceItem;
    }
    /**
     * Auto generated method that gets the related <code>InvoiceItem</code> by the relation named <code>ToInvoiceItem</code>.
     * @return the <code>InvoiceItem</code>
     * @throws RepositoryException if an error occurs
     */
    public InvoiceItem getToInvoiceItem() throws RepositoryException {
        if (this.toInvoiceItem == null) {
            this.toInvoiceItem = getRelatedOne(InvoiceItem.class, "ToInvoiceItem");
        }
        return this.toInvoiceItem;
    }
    /**
     * Auto generated method that gets the related <code>Agreement</code> by the relation named <code>Agreement</code>.
     * @return the <code>Agreement</code>
     * @throws RepositoryException if an error occurs
     */
    public Agreement getAgreement() throws RepositoryException {
        if (this.agreement == null) {
            this.agreement = getRelatedOne(Agreement.class, "Agreement");
        }
        return this.agreement;
    }

    /**
     * Auto generated value setter.
     * @param fromInvoiceItem the fromInvoiceItem to set
    */
    public void setFromInvoiceItem(InvoiceItem fromInvoiceItem) {
        this.fromInvoiceItem = fromInvoiceItem;
    }
    /**
     * Auto generated value setter.
     * @param toInvoiceItem the toInvoiceItem to set
    */
    public void setToInvoiceItem(InvoiceItem toInvoiceItem) {
        this.toInvoiceItem = toInvoiceItem;
    }
    /**
     * Auto generated value setter.
     * @param agreement the agreement to set
    */
    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }


    /** {@inheritDoc} */
    @Override
    public void fromMap(Map<String, Object> mapValue) {
        preInit();
        setInvoiceItemAssocId((String) mapValue.get("invoiceItemAssocId"));
        setInvoiceIdFrom((String) mapValue.get("invoiceIdFrom"));
        setInvoiceItemSeqIdFrom((String) mapValue.get("invoiceItemSeqIdFrom"));
        setInvoiceIdTo((String) mapValue.get("invoiceIdTo"));
        setInvoiceItemSeqIdTo((String) mapValue.get("invoiceItemSeqIdTo"));
        setAgreementId((String) mapValue.get("agreementId"));
        setAmount(convertToBigDecimal(mapValue.get("amount")));
        setLastUpdatedStamp((Timestamp) mapValue.get("lastUpdatedStamp"));
        setLastUpdatedTxStamp((Timestamp) mapValue.get("lastUpdatedTxStamp"));
        setCreatedStamp((Timestamp) mapValue.get("createdStamp"));
        setCreatedTxStamp((Timestamp) mapValue.get("createdTxStamp"));
        postInit();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> mapValue = new FastMap<String, Object>();
        mapValue.put("invoiceItemAssocId", getInvoiceItemAssocId());
        mapValue.put("invoiceIdFrom", getInvoiceIdFrom());
        mapValue.put("invoiceItemSeqIdFrom", getInvoiceItemSeqIdFrom());
        mapValue.put("invoiceIdTo", getInvoiceIdTo());
        mapValue.put("invoiceItemSeqIdTo", getInvoiceItemSeqIdTo());
        mapValue.put("agreementId", getAgreementId());
        mapValue.put("amount", getAmount());
        mapValue.put("lastUpdatedStamp", getLastUpdatedStamp());
        mapValue.put("lastUpdatedTxStamp", getLastUpdatedTxStamp());
        mapValue.put("createdStamp", getCreatedStamp());
        mapValue.put("createdTxStamp", getCreatedTxStamp());
        return mapValue;
    }


}