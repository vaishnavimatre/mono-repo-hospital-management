package org.dnyanyog.service;

import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;

import jakarta.validation.Valid;

public interface PatientService {
	
	public PatientResponse addPatient(@Valid PatientRequest request) throws Exception;

	  public PatientResponse updatePatient(long patient_id, PatientRequest request);

	  public PatientResponse searchPatient(long patient_id);

	  public PatientResponse deletePatient(long patient_id);
}