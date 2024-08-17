package org.dnyanyog.services;

import org.dnyanyog.dto.AppointmentRequest;
import org.dnyanyog.dto.AppointmentResponse;

public interface AppointmentService {
	 public AppointmentResponse addAppointment(AppointmentRequest request);
	 public  AppointmentResponse DeleteAppointment(Long Patient_id) ;
	  public AppointmentResponse Updateappointment(Long Patient_id, AppointmentRequest request);
	  public AppointmentResponse getSingleappointment(Long patient_id);
}
