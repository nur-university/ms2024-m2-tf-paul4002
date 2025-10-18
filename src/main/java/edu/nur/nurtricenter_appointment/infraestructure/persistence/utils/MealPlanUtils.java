package edu.nur.nurtricenter_appointment.infraestructure.persistence.utils;

import edu.nur.nurtricenter_appointment.domain.meal.Meal;
import edu.nur.nurtricenter_appointment.domain.mealplans.MealPlan;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.model.MealPersistenceModel;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.model.MealPlanPersistenceModel;

public class MealPlanUtils {
  public static MealPlanPersistenceModel mealPlanToPersistenceModel(MealPlan mealPlan) {
    if (mealPlan == null) return new MealPlanPersistenceModel();
    MealPlanPersistenceModel persistenceModel = new MealPlanPersistenceModel();
    persistenceModel.setGeneralDescripcion(mealPlan.getGeneralDescription());
    persistenceModel.setNutritionalGoal(mealPlan.getNutritionalGoal());
    persistenceModel.setStartDate(mealPlan.getStartDate());
    persistenceModel.setEndDate(mealPlan.getEndDate());
    persistenceModel.setRestrictions(mealPlan.getRestrictions());
    persistenceModel.setAppointmentId(mealPlan.getAppointmentId());

    for(Meal meal : mealPlan.get_meals()) {
      MealPersistenceModel mealPersistenceModel = new MealPersistenceModel();
      mealPersistenceModel.setName(meal.getName());
      mealPersistenceModel.setSchedule(meal.getSchedule().getLabel());
      mealPersistenceModel.setTotalCalories(meal.getCalories().value());
      mealPersistenceModel.setMealPlan(persistenceModel);
      persistenceModel.getMeals().add(mealPersistenceModel);
    }

    return persistenceModel;
  }
}
