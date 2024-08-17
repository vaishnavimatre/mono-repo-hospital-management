package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class CaseData {

  @NotNull(message = "Patientname is mandatory")
  @NotBlank(message = "Patientname  should not be blank")
  @Size(max = 50, message = "Patientname  length should be at most 20 characters")
  private String patientNameInEnglish;

  @NotNull(message = "patient Id is mandatory")
  @NotBlank(message = "patient Id should not be blank")
  private String patient_id;

  @NotNull(message = "caseNumber is mandatory")
  @NotBlank(message = "caseNumber should not be blank")
  private String caseNumber;

  @NotNull(message = "Examination date is mandatory")
  @PastOrPresent(message = "examination date cannot be in the future")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private String examinationDate;

  @NotNull(message = "Symptoms is mandatory")
  @NotBlank(message = "Symptoms should not be blank")
  private String symptoms;

  @NotNull(message = "Prescription is mandatory")
  @NotBlank(message = "Prescription should not be blank")
  private String prescription;

  private long case_id;

  public long getCase_id() {
    return case_id;
  }

  public void setCase_id(long case_id) {
    this.case_id = case_id;
  }

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public void setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
  }

  public String getPatient_id() {
    return patient_id;
  }

  public void setPatient_id(String patient_id) {
    this.patient_id = patient_id;
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public String getExaminationDate() {
    return examinationDate;
  }

  public void setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getPrescription() {
    return prescription;
  }

  public void setPrescription(String prescription) {
    this.prescription = prescription;
  }
}
