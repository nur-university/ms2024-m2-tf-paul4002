package edu.nur.nurtricenter_appointment.infraestructure.persistence.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import edu.nur.nurtricenter_appointment.domain.nutritionists.INutritionistRepository;
import edu.nur.nurtricenter_appointment.domain.nutritionists.Nutritionist;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.model.NutritionistPersistenceModel;
import edu.nur.nurtricenter_appointment.infraestructure.persistence.utils.NutritionistUtils;

@Repository
public class NutritionistJpaRepository implements INutritionistRepository {

  @Autowired
  private NutritionistCrudRepository nutritionistCrudRepository;

  @Override
  public List<Nutritionist> getAll() {
    List<NutritionistPersistenceModel> nutritionistModels = Streamable
      .of(nutritionistCrudRepository.findAll())
      .toList();
    List<Nutritionist> nutritionists = new ArrayList<>();
    nutritionistModels.forEach((nutritionistModel) -> nutritionists.add(NutritionistUtils.persistenceModelToNutritionist(nutritionistModel)));
    return nutritionists;
  }

  @Override
  public UUID Add(Nutritionist nutritionist) {
    this.nutritionistCrudRepository.save(NutritionistUtils.nutritionistToPersistenceModel(nutritionist));
    return nutritionist.getId();
  }

  
}
