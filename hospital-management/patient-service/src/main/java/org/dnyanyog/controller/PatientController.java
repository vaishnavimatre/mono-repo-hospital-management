package org.dnyanyog.controller;

import org.dnyanyog.dto.PatientRequest;

import org.dnyanyog.dto.PatientResponse;
import org.dnyanyog.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

  @Autowired PatientServiceImpl patientService;

  @PostMapping(
      path = "/api/v1/patient/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public PatientResponse AddPatient(@RequestBody PatientRequest patientRequest) throws Exception {
    return patientService.AddPatient(patientRequest);
  }

  @PostMapping("/api/v1/patient/{patient_id}")
  public PatientResponse UpdatePatient(
      @PathVariable long patient_id, @RequestBody PatientRequest request) {
    return patientService.UpdatePatient(patient_id, request);
  }

  @GetMapping(path = "/api/v1/patient/{patient_id}")
  public PatientResponse SearchPatient(@PathVariable long patient_id) {

    return patientService.SearchPatient(patient_id);
  }

  @DeleteMapping(path = "/api/v1/patient/{patient_id}")
  public PatientResponse DeletePatient(@PathVariable long patient_id) {
    return patientService.deletePatient(patient_id);
  }
  @GetMapping(path = "/api/v1/case/patient/{patient_name_english}")
  public PatientResponse getCase(@PathVariable String patient_name_english) {

    return patientService.getPatientName(patient_name_english);
  }
}