package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentData {

  @NotNull(message = "Patientname is mandatory")
  @NotBlank(message = "Patientname  should not be blank")
  @Size(max = 50, message = "Patientname  length should be at most 20 characters")
  private String patient_name;

  @NotNull(message = "PatientId is mandatory")
  @NotBlank(message = "PatientId should not be blank") 
  private String patient_id;
  
  private long appointment_id;
  
  @NotNull(message = "Examination date is mandatory")
  @PastOrPresent(message = "examination date cannot be in the future")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private String examination_date;
  
  @NotNull(message = "Appointment Time is mandatory")
  @NotBlank(message = "Appointment Time should not be blank")
  private String appointment_time;

  public String getPatient_id() {
    return patient_id;
  }

  public void setPatient_id(String patient_id) {
    this.patient_id = patient_id;
  }

  public long getAppointment_id() {
    return appointment_id;
  }

  public void setAppointment_id(long appointment_id) {
    this.appointment_id = appointment_id;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public void setExamination_date(String examination_date) {
    this.examination_date = examination_date;
  }

  public String getPatient_name() {
    return patient_name;
  }

  public void setPatient_name(String patient_name) {
    this.patient_name = patient_name;
  }

  public String getAppointment_time() {
    return appointment_time;
  }

  public void setAppointment_time(String appointment_time) {
    this.appointment_time = appointment_time;
  }
}
