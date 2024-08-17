package org.dnyanyog.Services;

import org.dnyanyog.dto.CaseRequest;
import org.dnyanyog.dto.CaseResponse;

public interface CaseService {
  public CaseResponse addCases(CaseRequest caseRequest);

  public CaseResponse searchCases(long caseNumber);

  public String deleteCases(long patientId);
}