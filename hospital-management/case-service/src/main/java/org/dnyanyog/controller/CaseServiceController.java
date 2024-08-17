
package org.dnyanyog.controller;


import org.dnyanyog.dto.CaseRequest;
import org.dnyanyog.dto.CaseResponse;
import org.dnyanyog.Services.CaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseServiceController {
  @Autowired CaseServiceImpl caseServiceImpl;

  @PostMapping(
      path = "/api/v1/case/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CaseResponse addCase(@RequestBody CaseRequest request) {
    return caseServiceImpl.addCases(request);
  }
  

  @PostMapping(
      path = "/api/v1/case/{case_id}")
  public CaseResponse updateCase(@RequestBody CaseRequest request,@PathVariable long case_id) {
    return caseServiceImpl.Updatecase(case_id,request);
  }

  @GetMapping(
      path = "/api/v1/case/{case_id}")
  public CaseResponse searchCases(@PathVariable long case_id) {
    return caseServiceImpl.searchCases(case_id);
  }

  @DeleteMapping(
      path = "/api/v1/case/{case_id}")
  public CaseResponse deleteCases(@PathVariable long case_id) {
    return caseServiceImpl.deleteCase(case_id);
  }
  
  @GetMapping(path = "/api/v1/case/patient/{case_id}")
  public CaseResponse getCase(@PathVariable long case_id) {

    return caseServiceImpl.getCase(case_id);
  }
}