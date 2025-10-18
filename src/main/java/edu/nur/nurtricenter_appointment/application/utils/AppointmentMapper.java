package edu.nur.nurtricenter_appointment.application.utils;

import edu.nur.nurtricenter_appointment.application.appointments.attendAppointment.AppointmentDto;
import edu.nur.nurtricenter_appointment.application.appointments.attendAppointment.DiagnosisDto;
import edu.nur.nurtricenter_appointment.application.appointments.attendAppointment.MeasurementDto;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.Measurement;
import edu.nur.nurtricenter_appointment.domain.diagnosis.Diagnosis;

public class AppointmentMapper {
  public static AppointmentDto from(Appointment appointment) {
    if (appointment == null) return new AppointmentDto();
    AppointmentDto appointmentDto = new AppointmentDto(
      appointment.getId().toString(), 
      appointment.getPatientId().toString(), 
      appointment.getNutritionistId().toString(), 
      appointment.getType().getLabel(), 
      appointment.getCreationDate(), 
      appointment.getScheduledDate(), 
      appointment.getCancelDate(), 
      appointment.getStatus().getLabel(), 
      appointment.getAttendance().getLabel(), 
      appointment.getNotes());

    if (appointment.getMeasurement() != null) {
      Measurement measurement = appointment.getMeasurement();
      appointmentDto.measurementDto = new MeasurementDto(
        measurement.getWeight().value().value(), 
        measurement.getHeight().value().value(), 
        measurement.getImc().value(), 
        measurement.getBodyFat().value().value(), 
        measurement.getMuscleMass().value().value());
    }

    if (appointment.getDiagnosis() != null) {
      Diagnosis diagnosis = appointment.getDiagnosis();
      appointmentDto.diagnosisDto = new DiagnosisDto(
        diagnosis.getDescription(), 
        diagnosis.getNutritionalState().getLabel(), 
        diagnosis.getAssociatedRisks(), 
        diagnosis.getRecommendations(), 
        diagnosis.getGoals(), 
        diagnosis.getComments());
    }
    return appointmentDto;
  }
}
