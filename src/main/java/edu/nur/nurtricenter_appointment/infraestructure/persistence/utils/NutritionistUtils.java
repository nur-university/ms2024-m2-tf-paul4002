package edu.nur.nurtricenter_appointment.infraestructure.persistence.utils;

import edu.nur.nurtricenter_appointment.domain.nutritionists.Nutritionist;
import edu.nur.nurtricenter_appointment.domain.nutritionists.NutritionistSpecialty;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.persistenceModel.NutritionistPersistenceModel;

public class NutritionistUtils {
  public static Nutritionist persistenceModelToNutritionist(NutritionistPersistenceModel nutritionistModel) {
    return new Nutritionist(
      nutritionistModel.getId(),
      nutritionistModel.getName(),
      nutritionistModel.getLastname(),
      NutritionistSpecialty.fromLabel(nutritionistModel.getSpecialty()),
      nutritionistModel.getProfessionalLicense()
    );
  }

  public static NutritionistPersistenceModel nutritionistToPersistenceModel(Nutritionist nutritionist) {
    NutritionistPersistenceModel nutritionistPersistenceModel = new NutritionistPersistenceModel();
    nutritionistPersistenceModel.setId(nutritionist.getId());
    nutritionistPersistenceModel.setName(nutritionist.getName());
    nutritionistPersistenceModel.setLastname(nutritionist.getLastname());
    nutritionistPersistenceModel.setSpecialty(nutritionist.getSpecialty().getLabel());
    nutritionistPersistenceModel.setProfessionalLicense(nutritionist.getProfessionalLicense());
    return nutritionistPersistenceModel;
  }
}
