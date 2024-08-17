package org.dnyanyog.service;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.Enum.ResponseCode;

import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;
import org.dnyanyog.entity.Patient;
import org.dnyanyog.repo.PatientServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl {

  @Autowired private PatientServiceRepository patientRepo;
  private PatientResponse response;

  public PatientResponse AddPatient(@Valid PatientRequest request) throws Exception {
    PatientResponse patientResponse = PatientResponse.getInstance();

    Patient patient =
        Patient.getInstance()
            .setPatientid(request.getPatientid())
            .setAddress(request.getAddress())
            .setBirth_date(request.getBirth_date())
            .setFirst_examination_date(request.getFirst_examination_date())
            .setGender(request.getGender())
            .setMobile_number(request.getMobile_number())
            .setPatientNameEnglish(request.getPatient_name_english())
            .setPatient_name_marathi(request.getPatient_name_marathi());

    try {

      patient = patientRepo.save(patient);

      patientResponse.setPatientid(patient.getPatientid());
      patientResponse.setAddress(patient.getAddress());
      patientResponse.setBirth_date(patient.getBirth_date());
      patientResponse.setFirst_examination_date(patient.getFirst_examination_date());
      patientResponse.setGender(patient.getGender());
      patientResponse.setMobile_number(patient.getMobile_number());
      patientResponse.setPatient_name_english(patient.getPatientNameEnglish());
      patientResponse.setPatient_name_marathi(patient.getPatient_name_marathi());

      patientResponse.setStatus(ResponseCode.ADD_PATIENT.getStatus());
      patientResponse.setMessage(ResponseCode.ADD_PATIENT.getMessage());

    } catch (Exception e) {
      patientResponse.setStatus(ResponseCode.ADD_PATIENT_FAILED.getStatus());
      patientResponse.setMessage(ResponseCode.ADD_PATIENT_FAILED.getMessage());
    }

    return patientResponse;
  }

  public PatientResponse UpdatePatient(Long patient_id, PatientRequest request) {
    Optional<Patient> optionalPatient = patientRepo.findById(patient_id);

    PatientResponse response = PatientResponse.getInstance();
    if (optionalPatient.isEmpty()) {
      response.setStatus(ResponseCode.UPDATE_PATIENT_FAILED.getStatus());
      response.setMessage(ResponseCode.UPDATE_PATIENT_FAILED.getMessage());
    } else {
      Patient patient = optionalPatient.get();

      patient.setAddress(request.getAddress());
      patient.setMobile_number(request.getMobile_number());
      patient.setBirth_date(request.getBirth_date());
      patient.setFirst_examination_date(request.getFirst_examination_date());
      patient.setGender(request.getGender());
      patient.setPatientNameEnglish(request.getPatient_name_english());
      patient.setPatient_name_marathi(request.getPatient_name_marathi());

      patientRepo.save(patient);

      PatientResponse patientResponse =
          PatientResponse.getInstance()
              .setPatientid(patient.getPatientid())
              .setAddress(patient.getAddress())
              .setBirth_date(patient.getBirth_date())
              .setFirst_examination_date(patient.getFirst_examination_date())
              .setGender(patient.getGender())
              .setMobile_number(patient.getMobile_number())
              .setPatient_name_english(patient.getPatientNameEnglish())
              .setPatient_name_marathi(patient.getPatient_name_marathi());

      response.setMessage(ResponseCode.UPDATE_PATIENT.getMessage());
      response.setStatus(ResponseCode.UPDATE_PATIENT.getStatus());
    }

    return response;
  }

  public PatientResponse SearchPatient(Long patient_id) {
    Optional<Patient> optionalPatient = patientRepo.findById(patient_id);
    PatientResponse patientResponse =  PatientResponse.getInstance();
    if (optionalPatient.isEmpty()) {
    	patientResponse.setMessage(ResponseCode.SEARCH_PATIENT_FAILED.getMessage());
    	patientResponse.setStatus(ResponseCode.SEARCH_PATIENT_FAILED.getStatus());
    } else {
      Patient patient = optionalPatient.get();
      
      patientResponse.setPatientid(patient.getPatientid());
      patientResponse.setAddress(patient.getAddress());
      patientResponse.setBirth_date(patient.getBirth_date());
      patientResponse.setFirst_examination_date(patient.getFirst_examination_date());
      patientResponse.setGender(patient.getGender());
      patientResponse.setMobile_number(patient.getMobile_number());
      patientResponse.setPatient_name_english(patient.getPatientNameEnglish());
      patientResponse.setPatient_name_marathi(patient.getPatient_name_marathi());
      patientResponse.setMessage(ResponseCode.SEARCH_PATIENT.getMessage());
      patientResponse.setStatus(ResponseCode.SEARCH_PATIENT.getStatus());
    }
    return patientResponse;
  }

  public PatientResponse getPatientName(String patient_name_english) {
    List<Patient> optionalPatient = patientRepo.findByPatientNameEnglish(patient_name_english);

    PatientResponse patientResponse = PatientResponse.getInstance();
    if (optionalPatient.isEmpty()) {
      patientResponse.setMessage(ResponseCode.SEARCH_PATIENT_FAILED.getMessage());
      patientResponse.setStatus(ResponseCode.SEARCH_PATIENT_FAILED.getStatus());
    } else {
      Patient patients = optionalPatient.get(0);
      patientResponse.setMessage(ResponseCode.SEARCH_PATIENT.getMessage());
      patientResponse.setStatus(ResponseCode.SEARCH_PATIENT.getStatus());
    }
    return patientResponse;
  }

  public PatientResponse deletePatient(Long patient_id) {
	   PatientResponse patientResponse = PatientResponse.getInstance();
    Optional<Patient> optionalPatient = patientRepo.findById(patient_id);

    if (optionalPatient.isEmpty()) {
    	patientResponse.setMessage(ResponseCode.DELETE_PATIENT_FAILED.getMessage());
    	patientResponse.setStatus(ResponseCode.DELETE_PATIENT_FAILED.getStatus());
    } else {

      Patient patients = optionalPatient.get();
      patients.setStatus("DELETED");
      patientRepo.delete(patients);

      patientResponse.setMessage(ResponseCode.DELETE_PATIENT.getMessage());
      patientResponse.setStatus(ResponseCode.DELETE_PATIENT.getStatus());
      patientResponse.setPatientid(patients.getPatientid());
      patientResponse.setAddress(patients.getAddress());
      patientResponse.setBirth_date(patients.getBirth_date());
      patientResponse.setFirst_examination_date(patients.getFirst_examination_date());
      patientResponse.setGender(patients.getGender());
      patientResponse.setMobile_number(patients.getMobile_number());
      patientResponse.setPatient_name_english(patients.getPatientNameEnglish());
      patientResponse.setPatient_name_marathi(patients.getPatient_name_marathi());
    }
    return patientResponse;
  }
}
