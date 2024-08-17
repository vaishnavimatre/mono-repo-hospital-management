package org.dnyanyog.services;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.Enum.ResponseCode;
import org.dnyanyog.Repo.AppointmentRepository;
import org.dnyanyog.dto.AppointmentRequest;
import org.dnyanyog.dto.AppointmentResponse;
import org.dnyanyog.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class AppointmentServiceImpl {

  @Autowired private AppointmentRepository appointmentrepo;

  @Autowired private AppointmentResponse response;

  public AppointmentResponse addAppointment(@Valid AppointmentRequest request) throws Exception {

    Appointment appointmentTable =
        Appointment.getInstanace()
            .setPatientid(request.getPatient_id())
            .setPatient_name(request.getPatient_name())
            .setExamination_date(request.getExamination_date())
            .setAppointment_time(request.getAppointment_time())
            .setAppointment_id(request.getAppointment_id());
    try {
      appointmentTable = appointmentrepo.save(appointmentTable);

      AppointmentResponse appointmentresponse =
          AppointmentResponse.getInstance()
              .setPatientid(appointmentTable.getPatientid())
              .setPatient_name(appointmentTable.getPatient_name())
              .setExamination_date(appointmentTable.getExamination_date())
              .setAppointment_id(appointmentTable.getAppointment_id())
              .setAppointment_time(appointmentTable.getAppointment_time());

      response.setMessage(ResponseCode.Add_Appointment_Success.getMessage());
      response.setStatus(ResponseCode.Add_Appointment_Success.getStatus());

    } catch (Exception e) {
      response.setStatus(ResponseCode.Add_Appointment_Fail.getStatus());
      response.setMessage(ResponseCode.Add_Appointment_Fail.getMessage());
    }

    return response;
  }

  public AppointmentResponse DeleteAppointment(Long appointment_id) {
    Optional<Appointment> receiveData = appointmentrepo.findById(appointment_id);
    if (receiveData.isPresent()) {
      appointmentrepo.deleteById(appointment_id);
      response.setAppointment_id(appointment_id);

      response.setMessage(ResponseCode.Delete_Appointment_Success.getMessage());
      response.setStatus(ResponseCode.Delete_Appointment_Success.getStatus());
    }
    return response;
  }

  public AppointmentResponse Updateappointment(Long appointment_id, AppointmentRequest request) {
    Optional<Appointment> receiveData = appointmentrepo.findById(appointment_id);
    if (receiveData.isEmpty()) {
      response.setMessage(ResponseCode.Update_Appointment_Fail.getMessage());
      response.setStatus(ResponseCode.Update_Appointment_Fail.getStatus());

    } else {
      Appointment appointmentTable = receiveData.get();

      appointmentTable.setPatient_name(request.getPatient_name());
      appointmentTable.setExamination_date(request.getExamination_date());
      appointmentTable.setAppointment_id(request.getAppointment_id());
      appointmentTable.setAppointment_time(request.getAppointment_time());
      appointmentrepo.save(appointmentTable);
      response.setMessage(ResponseCode.Update_Appointment_Success.getMessage());
      response.setStatus(ResponseCode.Update_Appointment_Success.getStatus());
    }
    return response;
  }

  public AppointmentResponse getSingleappointment(Long appointment_id) {
    Optional<Appointment> receiveData = appointmentrepo.findById(appointment_id);
    if (receiveData.isEmpty()) {
      response.setMessage(ResponseCode.Search_Appointment_Fail.getMessage());
      response.setStatus(ResponseCode.Search_Appointment_Fail.getStatus());

    } else {
      Appointment appointment = receiveData.get();

      response.setMessage(ResponseCode.Search_Appointment_Success.getMessage());
      response.setStatus(ResponseCode.Search_Appointment_Success.getStatus());

      AppointmentResponse appointmentresponse =
          AppointmentResponse.getInstance()
              .setPatientid(appointment.getPatientid())
              .setPatient_name(appointment.getPatient_name())
              .setExamination_date(appointment.getExamination_date())
              .setAppointment_id(appointment.getAppointment_id())
              .setAppointment_time(appointment.getAppointment_time());
    }
    return response;
  }

  public AppointmentResponse getCase(String patient_id) {
    List<Appointment> optionalCase = appointmentrepo.findBypatientid(patient_id);

    if (optionalCase.isEmpty()) {
      response.setMessage(ResponseCode.Search_Appointment_Fail.getMessage());
      response.setStatus(ResponseCode.Search_Appointment_Fail.getStatus());
    } else {
      Appointment appointment = optionalCase.get(0);
      response.setMessage(ResponseCode.Search_Appointment_Success.getMessage());
      response.setStatus(ResponseCode.Search_Appointment_Success.getStatus());
    }
    return response;
  }
}
