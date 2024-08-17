package org.dnyanyog.Entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cases {
  @Id @GeneratedValue @Column(name = "caseId", nullable = false, insertable = true, updatable = false)
  private long case_id;

  public long getCase_id() {
    return case_id;
  }

  public Cases setCase_id(long case_id) {
    this.case_id = case_id;
    return this;
  }

  @Column (nullable = false, insertable = true, updatable = false, length = 50)
  private String patientNameInEnglish;

  @Column(name = "patientId", nullable = false, insertable = true, updatable = false)
  private String patient_id;

  @Column private String Status;

  public String getStatus() {
    return Status;
  }

  public void setStatus(String status) {
    Status = status;
  }

  public String getPatient_id() {
    return patient_id;
  }

  public Cases setPatient_id(String patient_id) {
    this.patient_id = patient_id;
    return this;
  }

  @Column private String caseNumber;

  @Column private String examinationDate;

  @Column private String symptoms;

  @Column private String prescription;

  public static Cases getInstanace() {
    return new Cases();
  }

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public Cases setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
   return this; 
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public Cases setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
    return this;
  }

  public String getExaminationDate() {
    return examinationDate;
  }

  public Cases setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public Cases setSymptoms(String symptoms) {
    this.symptoms = symptoms;
    return this;
  }

  public String getPrescription() {
    return prescription;
  }

  public Cases setPrescription(String prescription) {
    this.prescription = prescription;
    return this;
  }
}
