package edu.nur.nurtricenter_appointment.infraestructure.persistence.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import edu.nur.nurtricenter_appointment.infraestructure.persistence.model.NutritionistPersistenceModel;

public interface NutritionistCrudRepository extends CrudRepository<NutritionistPersistenceModel, UUID> {

}
