package edu.nur.nurtricenter_appointment.infraestructure.persistence.utils;

import java.util.UUID;

import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.AppointmentAttendance;
import edu.nur.nurtricenter_appointment.domain.appointments.AppointmentStatus;
import edu.nur.nurtricenter_appointment.domain.appointments.AppointmentType;
import edu.nur.nurtricenter_appointment.domain.appointments.Measurement;
import edu.nur.nurtricenter_appointment.domain.diagnosis.Diagnosis;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.persistenceModel.AppointmentPersistenceModel;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.persistenceModel.DiagnosisPersistenceModel;

public class AppointmentUtils {
  public static AppointmentPersistenceModel appointmentToPersistenceModel(Appointment appointment) {
    AppointmentPersistenceModel appointmentPersistenceModel = new AppointmentPersistenceModel();
    appointmentPersistenceModel.setId(appointment.getId());
    appointmentPersistenceModel.setPatientId(appointment.getPatientId());
    appointmentPersistenceModel.setNutritionistId(appointment.getNutritionistId());
    appointmentPersistenceModel.setType(appointment.getType().getLabel());
    appointmentPersistenceModel.setCreationDate(appointment.getCreationDate());
    appointmentPersistenceModel.setScheduledDate(appointment.getScheduledDate());
    appointmentPersistenceModel.setCancelDate(appointment.getCancelDate());
    appointmentPersistenceModel.setStatus(appointment.getStatus().getLabel());
    appointmentPersistenceModel.setAttendance(appointment.getAttendance().getLabel());
    if(appointment.getNotes() != null) appointmentPersistenceModel.setNotes(appointment.getNotes());
    if(appointment.getMeasurement() != null) {
      Measurement measurement = appointment.getMeasurement();
      appointmentPersistenceModel.setWeight(measurement.getWeight().value().value());
      appointmentPersistenceModel.setHeight(measurement.getHeight().value().value());
      appointmentPersistenceModel.setImc(measurement.getImc().value());
      appointmentPersistenceModel.setBodyFat(measurement.getBodyFat().value().value());
      appointmentPersistenceModel.setMuscleMass(measurement.getMuscleMass().value().value());
    }
    if(appointment.getDiagnosis() != null) {
      Diagnosis diagnosis = appointment.getDiagnosis();
      DiagnosisPersistenceModel diagnosisPersistenceModel = new DiagnosisPersistenceModel();
      diagnosisPersistenceModel.setDescription(diagnosis.getDescription());
      diagnosisPersistenceModel.setNutritionalState(diagnosis.getNutritionalState().getLabel());
      diagnosisPersistenceModel.setAssociatedRisks(diagnosis.getAssociatedRisks());
      diagnosisPersistenceModel.setRecommendations(diagnosis.getRecommendations());
      diagnosisPersistenceModel.setGoals(diagnosis.getGoals());
      diagnosisPersistenceModel.setComments(diagnosis.getComments());
      appointmentPersistenceModel.setDiagnosis(diagnosisPersistenceModel);
    }
    return appointmentPersistenceModel;
  }

  public static Appointment persistenceModelToAppointment(AppointmentPersistenceModel persistenceModel) {
    if (persistenceModel == null) return new Appointment();
    return new Appointment(
      persistenceModel.getId(), 
      persistenceModel.getPatientId(), 
      persistenceModel.getNutritionistId(), 
      AppointmentType.fromLabel(persistenceModel.getType()), 
      persistenceModel.getCreationDate(), 
      persistenceModel.getScheduledDate(), 
      persistenceModel.getCancelDate(), 
      AppointmentStatus.fromLabel(persistenceModel.getStatus()), 
      AppointmentAttendance.fromLabel(persistenceModel.getAttendance()), 
      persistenceModel.getNotes());
  }
}
