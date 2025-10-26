package edu.nur.nurtricenter_appointment.domain.nutritionists;

import java.util.UUID;

public interface INutritionistRepository {
  UUID Add(Nutritionist nutritionist);
}
