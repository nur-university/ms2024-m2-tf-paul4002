package edu.nur.nurtricenter_appointment.infraestructure.persistence.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import edu.nur.nurtricenter_appointment.infraestructure.persistence.model.AppointmentPersistenceModel;

public interface AppointmentCrudRepository extends CrudRepository<AppointmentPersistenceModel, UUID>  {

}
