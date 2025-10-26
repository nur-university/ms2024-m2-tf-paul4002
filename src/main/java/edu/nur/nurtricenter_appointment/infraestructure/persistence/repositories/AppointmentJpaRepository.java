package edu.nur.nurtricenter_appointment.infraestructure.persistence.repositories;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.IAppointmentRepository;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.persistenceModel.AppointmentPersistenceModel;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.utils.AppointmentUtils;

@Repository
public class AppointmentJpaRepository implements IAppointmentRepository {
  @Autowired
  private AppointmentCrudRepository appointmentCrudRepository;

  @Override
  public boolean existsAppointmentNearTime(UUID nutritionistId, LocalDateTime start, LocalDateTime end) {
    return this.appointmentCrudRepository.existsAppointmentNearTime(nutritionistId, start, end);
  }

  @Override
  public UUID add(Appointment appointment) {
    this.appointmentCrudRepository.save(AppointmentUtils.appointmentToPersistenceModel(appointment));
    return appointment.getId();
  }

  @Override
  public Appointment find(UUID id) {
    AppointmentPersistenceModel persistenceModel = this.appointmentCrudRepository.findById(id).get();
    return AppointmentUtils.persistenceModelToAppointment(persistenceModel);
  }

  @Override
  public Appointment cancel(UUID id) {
    AppointmentPersistenceModel appointmentPersistenceModel = this.appointmentCrudRepository.findById(id).orElse(null);
    Appointment appointment = AppointmentUtils.persistenceModelToAppointment(appointmentPersistenceModel);
    appointment.cancel();
    appointmentPersistenceModel = AppointmentUtils.appointmentToPersistenceModel(appointment);
    this.appointmentCrudRepository.save(appointmentPersistenceModel);
    return AppointmentUtils.persistenceModelToAppointment(appointmentPersistenceModel);
  }

  @Override
  public Appointment notAttended(UUID id) {
    AppointmentPersistenceModel appointmentPersistenceModel = this.appointmentCrudRepository.findById(id).orElse(null);
    Appointment appointment = AppointmentUtils.persistenceModelToAppointment(appointmentPersistenceModel);
    appointment.notAttended();
    appointmentPersistenceModel = AppointmentUtils.appointmentToPersistenceModel(appointment);
    this.appointmentCrudRepository.save(appointmentPersistenceModel);
    return AppointmentUtils.persistenceModelToAppointment(appointmentPersistenceModel);
  }

  @Override
  public UUID attend(Appointment appointment) {
    AppointmentPersistenceModel persistenceModel = AppointmentUtils.appointmentToPersistenceModel(appointment);
    return this.appointmentCrudRepository.save(persistenceModel).getId();
  }

  
}
