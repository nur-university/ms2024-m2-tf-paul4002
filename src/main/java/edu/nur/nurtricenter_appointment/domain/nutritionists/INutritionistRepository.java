package edu.nur.nurtricenter_appointment.domain.nutritionists;

import java.util.List;
import java.util.UUID;

public interface INutritionistRepository {
  List<Nutritionist> getAll();
  UUID Add(Nutritionist nutritionist);
}
