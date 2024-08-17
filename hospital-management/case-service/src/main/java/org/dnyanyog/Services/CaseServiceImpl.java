package org.dnyanyog.Services;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.Enum.ResponseCode;
import org.dnyanyog.Repo.CaseRepository;
import org.dnyanyog.dto.CaseRequest;
import org.dnyanyog.dto.CaseResponse;
import org.dnyanyog.Entity.Cases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
@Component
public class CaseServiceImpl  {

  @Autowired CaseRepository caseRepo;

  @Autowired CaseResponse caseResponse;

  @Autowired CaseRequest caseRequest;

  public CaseResponse addCases(@Valid CaseRequest caseRequest) {
    Cases cases =
        Cases.getInstanace()
            .setPatientNameInEnglish(caseRequest.getPatientNameInEnglish())
            .setPatient_id(caseRequest.getPatient_id())
            .setCaseNumber(caseRequest.getCaseNumber())
            .setExaminationDate(caseRequest.getExaminationDate())
            .setSymptoms(caseRequest.getSymptoms())
            .setPrescription(caseRequest.getPrescription());
    try {
      caseRepo.save(cases);

      caseResponse.setStatus(ResponseCode.ADD_CASES_SUCCESS.getStatus());
      caseResponse.setMessage(ResponseCode.ADD_CASES_SUCCESS.getMessage());

    } catch (Exception e) {
    	caseResponse.setStatus(ResponseCode.ADD_CASES_FAILED.getStatus());
    	caseResponse.setMessage(ResponseCode.ADD_CASES_FAILED.getMessage());
      
    }
   

    return caseResponse;
  }
  public CaseResponse Updatecase(Long case_id, CaseRequest request) {
	    Optional<Cases> receiveData = caseRepo.findById(case_id);
	    if (receiveData.isEmpty()) {
	    	caseResponse.setStatus(ResponseCode.UPDATE_CASES_FAILURE.getStatus());
	        caseResponse.setMessage(ResponseCode.UPDATE_CASES_FAILURE.getMessage());

	    } else {
	    	Cases cases  = receiveData.get();
	    	
	    	  cases.setPatientNameInEnglish(request.getPatientNameInEnglish());
	    	  cases.setPatient_id(request.getPatient_id());
	    	  cases.setCaseNumber(request.getCaseNumber());
	    	  cases.setExaminationDate(request.getExaminationDate());
	    	  cases.setSymptoms(request.getSymptoms());
	    	  cases.setPrescription(request.getPrescription());
	          
	          caseRepo.save(cases);
	          caseResponse  .setMessage(ResponseCode.UPDATE_CASES_SUCCESS.getMessage());
		    	 caseResponse.setStatus(ResponseCode.UPDATE_CASES_SUCCESS.getStatus());
	    }
	    return  caseResponse;
	  }
  
  public CaseResponse searchCases(long case_id) {
    Optional<Cases> receivedCases = caseRepo.findById(case_id);
    if (receivedCases.isEmpty()) {
      caseResponse.setStatus(ResponseCode.SEARCH_CASES_FAILURE.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_FAILURE.getMessage());
    } else {
      Cases cases = receivedCases.get();
      caseResponse.setPatientNameInEnglish(cases.getPatientNameInEnglish());
      caseResponse.setPatient_id(cases.getPatient_id());
      caseResponse.setCaseNumber(cases.getCaseNumber());
      caseResponse.setExaminationDate(cases.getExaminationDate());
      caseResponse.setSymptoms(cases.getSymptoms());
      caseResponse.setPrescription(cases.getPrescription());

      caseResponse.setStatus(ResponseCode.SEARCH_CASES_SUCCESS.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_SUCCESS.getMessage());
    }
    return caseResponse;
  }


  public CaseResponse deleteCase(Long case_id) {
    Optional<Cases> optionalCase = caseRepo.findById(case_id);

    if (optionalCase.isEmpty()) {
      caseResponse.setMessage(ResponseCode.DELETE_Case_FAILED.getMessage());
      caseResponse.setStatus(ResponseCode.DELETE_Case_FAILED.getStatus());
    } else {
      Cases cases = optionalCase.get();
    //  cases.setStatus(Cases.Status.DELETED);
      caseRepo.save(cases);

      caseResponse.setMessage(ResponseCode.DELETE_case.getMessage());
      caseResponse.setStatus(ResponseCode.DELETE_case.getStatus());
      caseResponse.setPatientNameInEnglish(cases.getPatientNameInEnglish());
      caseResponse.setPatient_id(cases.getPatient_id());
      caseResponse.setCaseNumber(cases.getCaseNumber());
      caseResponse.setExaminationDate(cases.getExaminationDate());
      caseResponse.setSymptoms(cases.getSymptoms());
      caseResponse.setPrescription(cases.getPrescription());

    }
    return caseResponse;
  }
  public CaseResponse getCase(Long case_id) {
	    Optional<Cases> optionalCase = caseRepo.findById(case_id);

	    if (optionalCase.isEmpty()) {
	      caseResponse.setMessage(ResponseCode.SEARCH_CASES_FAILURE.getMessage());
	      caseResponse.setStatus(ResponseCode.SEARCH_CASES_FAILURE.getStatus());
	    } else {
	      Cases cases = optionalCase.get();
	      caseResponse.setMessage(ResponseCode.SEARCH_CASES_SUCCESS.getMessage());
	      caseResponse.setStatus(ResponseCode.SEARCH_CASES_SUCCESS.getStatus());
	    }
	    return caseResponse;
	  }
}