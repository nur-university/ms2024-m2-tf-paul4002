package edu.nur.nurtricenter_appointment.application.utils;

import edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment.ResponseAppointmentDto;
import edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment.ScheduleAppointmentDto;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;

public class ResponseAppointmentMapper {
  public static ResponseAppointmentDto from(Appointment appointment) {
    if (appointment == null) return new ResponseAppointmentDto();
    return new ResponseAppointmentDto(
      appointment.getId().toString(), 
      appointment.getPatientId().toString(), 
      appointment.getNutritionistId().toString(), 
      appointment.getType().getLabel(), 
      appointment.getCreationDate(), 
      appointment.getScheduledDate(), 
      appointment.getCancelDate(),
      appointment.getStatus().getLabel(),
      appointment.getAttendance().getLabel());
  }

  public static ResponseAppointmentDto from(ScheduleAppointmentDto appointmentDto) {
    if (appointmentDto == null) return new ResponseAppointmentDto();
    return new ResponseAppointmentDto(
      appointmentDto.patientId,
      appointmentDto.nutritionistId, 
      appointmentDto.type, 
      appointmentDto.scheduleDate);
  }
}
