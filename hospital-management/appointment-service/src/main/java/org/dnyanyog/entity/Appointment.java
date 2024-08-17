package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class  Appointment  {

  @Column private String patientid;

  @Column(nullable = false, insertable = true, updatable = false, length = 50)
  private String patient_name;

  @GeneratedValue
  @Id
  @Column(name = "appointmentId", nullable = false, insertable = true, updatable = false)
  private long appointment_id;

  @Column private String examination_date;
  @Column private String appointment_time;

  public static Appointment getInstanace() {
    return new Appointment();
  }

  public String getPatient_name() {
    return patient_name;
  }

  public Appointment setPatient_name(String patient_name) {
    this.patient_name = patient_name;
    return this;
  }

  public String getPatientid() {
    return patientid;
  }

  public  Appointment setPatientid(String patientid) {
    this.patientid = patientid;
    return this;
  }

  public long getAppointment_id() {
    return appointment_id;
  }

  public  Appointment  setAppointment_id(long appointment_id) {
    this.appointment_id = appointment_id;
    return this;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public Appointment setExamination_date(String examination_date) {
    this.examination_date = examination_date;
    return this;
  }

  public String getAppointment_time() {
    return appointment_time;
  }

  public Appointment setAppointment_time(String appointment_time) {
    this.appointment_time = appointment_time;
    return this;
  }
}
