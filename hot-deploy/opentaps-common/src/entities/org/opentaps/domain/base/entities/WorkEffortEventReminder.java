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
import java.lang.Long;
import java.lang.String;
import java.sql.Timestamp;

/**
 * Auto generated base entity WorkEffortEventReminder.
 */
@javax.persistence.Entity
@Table(name="WORK_EFFORT_EVENT_REMINDER")
public class WorkEffortEventReminder extends Entity {
static {
java.util.Map<String, String> fields = new java.util.HashMap<String, String>();
        fields.put("workEffortId", "WORK_EFFORT_ID");
        fields.put("contactMechId", "CONTACT_MECH_ID");
        fields.put("sequenceId", "SEQUENCE_ID");
        fields.put("isPopup", "IS_POPUP");
        fields.put("reminderDateTime", "REMINDER_DATE_TIME");
        fields.put("repeatCount", "REPEAT_COUNT");
        fields.put("repeatInterval", "REPEAT_INTERVAL");
        fields.put("currentCount", "CURRENT_COUNT");
        fields.put("recurrenceOffset", "RECURRENCE_OFFSET");
        fields.put("localeId", "LOCALE_ID");
        fields.put("timeZoneId", "TIME_ZONE_ID");
        fields.put("lastUpdatedStamp", "LAST_UPDATED_STAMP");
        fields.put("lastUpdatedTxStamp", "LAST_UPDATED_TX_STAMP");
        fields.put("createdStamp", "CREATED_STAMP");
        fields.put("createdTxStamp", "CREATED_TX_STAMP");
fieldMapColumns.put("WorkEffortEventReminder", fields);
}
  public static enum Fields implements EntityFieldInterface<WorkEffortEventReminder> {
    workEffortId("workEffortId"),
    contactMechId("contactMechId"),
    sequenceId("sequenceId"),
    isPopup("isPopup"),
    reminderDateTime("reminderDateTime"),
    repeatCount("repeatCount"),
    repeatInterval("repeatInterval"),
    currentCount("currentCount"),
    recurrenceOffset("recurrenceOffset"),
    localeId("localeId"),
    timeZoneId("timeZoneId"),
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

   @EmbeddedId

   @FieldBridge(impl = org.opentaps.domain.base.entities.bridge.WorkEffortEventReminderPkBridge.class)
     private WorkEffortEventReminderPk id = new WorkEffortEventReminderPk();
   
    /**
     * Auto generated Id accessor.
     * @return <code>WorkEffortEventReminderPk</code>
     */
      public WorkEffortEventReminderPk getId() {
         return id;
      }
    /**
     * Auto generated Id setter.
     * @param id a <code>WorkEffortEventReminderPk</code> value to set
    */   
      public void setId(WorkEffortEventReminderPk id) {
         this.id = id;
      }
   @Column(name="CONTACT_MECH_ID")
   private String contactMechId;
   @Column(name="IS_POPUP")
   private String isPopup;
   @Column(name="REMINDER_DATE_TIME")
   private Timestamp reminderDateTime;
   @Column(name="REPEAT_COUNT")
   private Long repeatCount;
   @Column(name="REPEAT_INTERVAL")
   private Long repeatInterval;
   @Column(name="CURRENT_COUNT")
   private Long currentCount;
   @Column(name="RECURRENCE_OFFSET")
   private Long recurrenceOffset;
   @Column(name="LOCALE_ID")
   private String localeId;
   @Column(name="TIME_ZONE_ID")
   private String timeZoneId;
   @Column(name="LAST_UPDATED_STAMP")
   private Timestamp lastUpdatedStamp;
   @Column(name="LAST_UPDATED_TX_STAMP")
   private Timestamp lastUpdatedTxStamp;
   @Column(name="CREATED_STAMP")
   private Timestamp createdStamp;
   @Column(name="CREATED_TX_STAMP")
   private Timestamp createdTxStamp;
   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
   @JoinColumn(name="WORK_EFFORT_ID", insertable=false, updatable=false)
   @org.hibernate.annotations.Generated(
      org.hibernate.annotations.GenerationTime.ALWAYS
   )
   
   private WorkEffort workEffort = null;
   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
   @JoinColumn(name="CONTACT_MECH_ID", insertable=false, updatable=false)
   @org.hibernate.annotations.Generated(
      org.hibernate.annotations.GenerationTime.ALWAYS
   )
   
   private ContactMech contactMech = null;

  /**
   * Default constructor.
   */
  public WorkEffortEventReminder() {
      super();
      this.baseEntityName = "WorkEffortEventReminder";
      this.isView = false;
      
      this.primaryKeyNames = new ArrayList<String>();
      this.primaryKeyNames.add("workEffortId");this.primaryKeyNames.add("sequenceId");
      this.allFieldsNames = new ArrayList<String>();
      this.allFieldsNames.add("workEffortId");this.allFieldsNames.add("contactMechId");this.allFieldsNames.add("sequenceId");this.allFieldsNames.add("isPopup");this.allFieldsNames.add("reminderDateTime");this.allFieldsNames.add("repeatCount");this.allFieldsNames.add("repeatInterval");this.allFieldsNames.add("currentCount");this.allFieldsNames.add("recurrenceOffset");this.allFieldsNames.add("localeId");this.allFieldsNames.add("timeZoneId");this.allFieldsNames.add("lastUpdatedStamp");this.allFieldsNames.add("lastUpdatedTxStamp");this.allFieldsNames.add("createdStamp");this.allFieldsNames.add("createdTxStamp");
      this.nonPrimaryKeyNames = new ArrayList<String>();
      this.nonPrimaryKeyNames.addAll(allFieldsNames);
      this.nonPrimaryKeyNames.removeAll(primaryKeyNames);
  }

  /**
   * Constructor with a repository.
   * @param repository a <code>RepositoryInterface</code> value
   */
  public WorkEffortEventReminder(RepositoryInterface repository) {
      this();
      initRepository(repository);
  }

    /**
     * Auto generated value setter.
     * @param workEffortId the workEffortId to set
     */
    public void setWorkEffortId(String workEffortId) {
        id.setWorkEffortId(workEffortId);
    }
    /**
     * Auto generated value setter.
     * @param contactMechId the contactMechId to set
     */
    public void setContactMechId(String contactMechId) {
        this.contactMechId = contactMechId;
    }
    /**
     * Auto generated value setter.
     * @param sequenceId the sequenceId to set
     */
    public void setSequenceId(String sequenceId) {
        id.setSequenceId(sequenceId);
    }
    /**
     * Auto generated value setter.
     * @param isPopup the isPopup to set
     */
    public void setIsPopup(String isPopup) {
        this.isPopup = isPopup;
    }
    /**
     * Auto generated value setter.
     * @param reminderDateTime the reminderDateTime to set
     */
    public void setReminderDateTime(Timestamp reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }
    /**
     * Auto generated value setter.
     * @param repeatCount the repeatCount to set
     */
    public void setRepeatCount(Long repeatCount) {
        this.repeatCount = repeatCount;
    }
    /**
     * Auto generated value setter.
     * @param repeatInterval the repeatInterval to set
     */
    public void setRepeatInterval(Long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }
    /**
     * Auto generated value setter.
     * @param currentCount the currentCount to set
     */
    public void setCurrentCount(Long currentCount) {
        this.currentCount = currentCount;
    }
    /**
     * Auto generated value setter.
     * @param recurrenceOffset the recurrenceOffset to set
     */
    public void setRecurrenceOffset(Long recurrenceOffset) {
        this.recurrenceOffset = recurrenceOffset;
    }
    /**
     * Auto generated value setter.
     * @param localeId the localeId to set
     */
    public void setLocaleId(String localeId) {
        this.localeId = localeId;
    }
    /**
     * Auto generated value setter.
     * @param timeZoneId the timeZoneId to set
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
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
    public String getWorkEffortId() {
        return this.id.getWorkEffortId();
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getContactMechId() {
        return this.contactMechId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getSequenceId() {
        return this.id.getSequenceId();
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getIsPopup() {
        return this.isPopup;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getReminderDateTime() {
        return this.reminderDateTime;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Long</code>
     */
    public Long getRepeatCount() {
        return this.repeatCount;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Long</code>
     */
    public Long getRepeatInterval() {
        return this.repeatInterval;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Long</code>
     */
    public Long getCurrentCount() {
        return this.currentCount;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Long</code>
     */
    public Long getRecurrenceOffset() {
        return this.recurrenceOffset;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getLocaleId() {
        return this.localeId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getTimeZoneId() {
        return this.timeZoneId;
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
     * Auto generated method that gets the related <code>WorkEffort</code> by the relation named <code>WorkEffort</code>.
     * @return the <code>WorkEffort</code>
     * @throws RepositoryException if an error occurs
     */
    public WorkEffort getWorkEffort() throws RepositoryException {
        if (this.workEffort == null) {
            this.workEffort = getRelatedOne(WorkEffort.class, "WorkEffort");
        }
        return this.workEffort;
    }
    /**
     * Auto generated method that gets the related <code>ContactMech</code> by the relation named <code>ContactMech</code>.
     * @return the <code>ContactMech</code>
     * @throws RepositoryException if an error occurs
     */
    public ContactMech getContactMech() throws RepositoryException {
        if (this.contactMech == null) {
            this.contactMech = getRelatedOne(ContactMech.class, "ContactMech");
        }
        return this.contactMech;
    }

    /**
     * Auto generated value setter.
     * @param workEffort the workEffort to set
    */
    public void setWorkEffort(WorkEffort workEffort) {
        this.workEffort = workEffort;
    }
    /**
     * Auto generated value setter.
     * @param contactMech the contactMech to set
    */
    public void setContactMech(ContactMech contactMech) {
        this.contactMech = contactMech;
    }


    /** {@inheritDoc} */
    @Override
    public void fromMap(Map<String, Object> mapValue) {
        preInit();
        setWorkEffortId((String) mapValue.get("workEffortId"));
        setContactMechId((String) mapValue.get("contactMechId"));
        setSequenceId((String) mapValue.get("sequenceId"));
        setIsPopup((String) mapValue.get("isPopup"));
        setReminderDateTime((Timestamp) mapValue.get("reminderDateTime"));
        setRepeatCount((Long) mapValue.get("repeatCount"));
        setRepeatInterval((Long) mapValue.get("repeatInterval"));
        setCurrentCount((Long) mapValue.get("currentCount"));
        setRecurrenceOffset((Long) mapValue.get("recurrenceOffset"));
        setLocaleId((String) mapValue.get("localeId"));
        setTimeZoneId((String) mapValue.get("timeZoneId"));
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
        mapValue.put("workEffortId", getWorkEffortId());
        mapValue.put("contactMechId", getContactMechId());
        mapValue.put("sequenceId", getSequenceId());
        mapValue.put("isPopup", getIsPopup());
        mapValue.put("reminderDateTime", getReminderDateTime());
        mapValue.put("repeatCount", getRepeatCount());
        mapValue.put("repeatInterval", getRepeatInterval());
        mapValue.put("currentCount", getCurrentCount());
        mapValue.put("recurrenceOffset", getRecurrenceOffset());
        mapValue.put("localeId", getLocaleId());
        mapValue.put("timeZoneId", getTimeZoneId());
        mapValue.put("lastUpdatedStamp", getLastUpdatedStamp());
        mapValue.put("lastUpdatedTxStamp", getLastUpdatedTxStamp());
        mapValue.put("createdStamp", getCreatedStamp());
        mapValue.put("createdTxStamp", getCreatedTxStamp());
        return mapValue;
    }


}