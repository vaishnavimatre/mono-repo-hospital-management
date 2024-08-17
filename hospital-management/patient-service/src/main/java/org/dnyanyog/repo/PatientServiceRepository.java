package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientServiceRepository extends JpaRepository<Patient, Long> {
	 List<Patient>findByPatientNameEnglish( String patient_name_english);
}