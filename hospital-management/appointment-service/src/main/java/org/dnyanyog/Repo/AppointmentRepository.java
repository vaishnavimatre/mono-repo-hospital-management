package org.dnyanyog.Repo;

import java.util.List;

import org.dnyanyog.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
List<Appointment>findBypatientid(String patient_id);
}
