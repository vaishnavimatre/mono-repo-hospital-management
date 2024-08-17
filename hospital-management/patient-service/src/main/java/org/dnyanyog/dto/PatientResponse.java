package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class PatientResponse {

  private String status;
  private String message;
  private String patient_name_english;
  private String patient_name_marathi;
  private String mobile_number;
  private String gender;
  private String birth_date;
  private String first_examination_date;
  private String address;
  private long patientid;

  public long getPatientid() {
    return patientid;
  }

  public PatientResponse setPatientid(long patientid) {
    this.patientid = patientid;
    return this;
  }

 public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPatient_name_english() {
    return patient_name_english;
  }

  public PatientResponse setPatient_name_english(String patient_name_english) {
    this.patient_name_english = patient_name_english;
    return this;
  }

  public String getPatient_name_marathi() {
    return patient_name_marathi;
  }

  public PatientResponse setPatient_name_marathi(String patient_name_marathi) {
    this.patient_name_marathi = patient_name_marathi;
    return this;
  }

  public String getMobile_number() {
    return mobile_number;
  }

  public PatientResponse setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public PatientResponse setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getBirth_date() {
    return birth_date;
  }

  public PatientResponse setBirth_date(String birth_date) {
    this.birth_date = birth_date;
    return this;
  }

  public String getFirst_examination_date() {
    return first_examination_date;
  }

  public PatientResponse setFirst_examination_date(String first_examination_date) {
    this.first_examination_date = first_examination_date;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public PatientResponse setAddress(String address) {
    this.address = address;
    return this;
  }

  public static PatientResponse getInstance() {
    return new PatientResponse();
  }
}
