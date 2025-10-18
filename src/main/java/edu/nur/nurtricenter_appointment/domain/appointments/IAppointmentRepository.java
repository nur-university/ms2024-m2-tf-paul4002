package edu.nur.nurtricenter_appointment.domain.appointments;

import java.util.UUID;

public interface IAppointmentRepository {
  UUID add(Appointment appointment);
  Appointment find(UUID id);
  UUID attend(Appointment appointment);
  Appointment cancel(UUID id);
  Appointment notAttended(UUID id);
}
