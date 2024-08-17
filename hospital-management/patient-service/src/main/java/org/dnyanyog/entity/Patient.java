package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {

  @GeneratedValue
  @Id
  @Column(name = "patientId", nullable = false, insertable = true, updatable = false)
  private long patientid;

  
  @Column(nullable = false, insertable = true, updatable = false, length = 50)
  private String patientNameEnglish;

  @Column(nullable = false, insertable = true, updatable = false, length = 50)
  private String patient_name_marathi;

  @Column private String mobile_number;

  @Column private String gender;

  @Column private String birth_date;

  @Column private String first_examination_date;

  @Column private String address;

  @Column private String Status;
  
  public static Patient getInstance() {
	    return new Patient();
	  }

  public String getStatus() {
    return Status;
  }

  public void setStatus(String status) {
    Status = status;
  }

  public long getPatientid() {
    return patientid;
   
  }

  public Patient setPatientid(long patientid) {
    this.patientid = patientid;
    return this;
  }

  public String getPatientNameEnglish() {
    return patientNameEnglish;
  }

  public Patient setPatientNameEnglish(String patientNameEnglish) {
    this.patientNameEnglish = patientNameEnglish;
    return this;
  }

  public String getPatient_name_marathi() {
    return patient_name_marathi;
  }

  public Patient setPatient_name_marathi(String patient_name_marathi) {
    this.patient_name_marathi = patient_name_marathi;
    return this;
  }

  public String getMobile_number() {
    return mobile_number;
  }

  public Patient setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patient setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getBirth_date() {
    return birth_date;
  }

  public Patient setBirth_date(String birth_date) {
    this.birth_date = birth_date;
    return this;
  }

  public String getFirst_examination_date() {
    return first_examination_date;
  }

  public Patient setFirst_examination_date(String first_examination_date) {
    this.first_examination_date = first_examination_date;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Patient setAddress(String address) {
    this.address = address;
    return this;
  }
}
