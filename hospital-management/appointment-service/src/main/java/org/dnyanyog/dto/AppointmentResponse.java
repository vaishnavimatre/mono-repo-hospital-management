package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class AppointmentResponse {

  private String status;
  private String message;
  private String patient_name;
  private String patientid;
  private long appointment_id;
  private String examination_date;
  private String appointment_time;

 

  public String getPatientid() {
    return patientid;
  }

  public AppointmentResponse setPatientid(String patientid) {
    this.patientid = patientid;
    return this;
  }

  public long getAppointment_id() {
    return appointment_id;
  }

  public AppointmentResponse setAppointment_id(long appointment_id) {
    this.appointment_id = appointment_id;
    return this;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public AppointmentResponse setExamination_date(String examination_date) {
    this.examination_date = examination_date;
    return this;
  }

  public String getPatient_name() {
    return patient_name;
  }

  public AppointmentResponse setPatient_name(String patient_name) {
    this.patient_name = patient_name;
    return this;
  }

  public String getAppointment_time() {
    return appointment_time;
  }

  public AppointmentResponse setAppointment_time(String appointment_time) {
    this.appointment_time = appointment_time;
    return this;
  }

  public static AppointmentResponse getInstance() {
    return new AppointmentResponse();
  }

  public String getStatus() {
    return status;
  }

  public AppointmentResponse setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public AppointmentResponse setMessage(String message) {
    this.message = message;
    return this;
  }

 
}
