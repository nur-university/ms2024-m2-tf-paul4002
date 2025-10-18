package edu.nur.nurtricenter_appointment.infraestructure.persistence.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nur.nurtricenter_appointment.domain.mealplans.IMealPlanRepository;
import edu.nur.nurtricenter_appointment.domain.mealplans.MealPlan;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.model.MealPlanPersistenceModel;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.utils.MealPlanUtils;

@Repository
public class MealPlanJpaRepository implements IMealPlanRepository {

  @Autowired
  MealPlanCrudRepository mealPlanCrudRepository;

  @Override
  public UUID add(MealPlan mealPlan) {
    MealPlanPersistenceModel persistenceModel = MealPlanUtils.mealPlanToPersistenceModel(mealPlan);
    return this.mealPlanCrudRepository.save(persistenceModel).getId();
  }
}
