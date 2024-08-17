package org.dnyanyog.controller;

import org.dnyanyog.dto.AppointmentRequest;
import org.dnyanyog.dto.AppointmentResponse;
import org.dnyanyog.services.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointManagementController {

  @Autowired AppointmentServiceImpl appointmentService;

  @PostMapping(
      path = "/api/v1/appointment/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AppointmentResponse addAppointment(@RequestBody AppointmentRequest request) throws Exception {
    return appointmentService.addAppointment(request);
  }

  @GetMapping(
      path = "/api/v1/appointment/{appointment_id}")
  public AppointmentResponse getSingleappointment(@PathVariable long appointment_id)  {
    return appointmentService.getSingleappointment(appointment_id);
  }
  
  @PostMapping(
	      path = "/api/v1/appointment/{appointment_id}")
  public AppointmentResponse Updateappointment(@PathVariable long appointment_id, @RequestBody AppointmentRequest request) {
	    return appointmentService.Updateappointment(appointment_id,request);
	  }
  
  @DeleteMapping(
	      path = "/api/v1/appointment/{patient_id}")
  public  AppointmentResponse DeleteAppointment(@PathVariable long patient_id)   {
	    return appointmentService.getSingleappointment(patient_id);
	  }
}
