package edu.nur.nurtricenter_appointment.application.utils;

import edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist.NewNutritionistDto;
import edu.nur.nurtricenter_appointment.application.nutritionists.getNutritionist.NutritionistDto;
import edu.nur.nurtricenter_appointment.domain.nutritionists.Nutritionist;

public class NutritionistMapper {
  public static NutritionistDto from(Nutritionist nutritionist) {
    if (nutritionist == null) return new NutritionistDto();
    return new NutritionistDto(
      nutritionist.getId(),
      nutritionist.getName(),
      nutritionist.getLastname(),
      nutritionist.getSpecialty().name(),
      nutritionist.getProfessionalLicense());
  }

  public static NutritionistDto from(NewNutritionistDto newNutritionistDto) {
    if (newNutritionistDto == null) return new NutritionistDto();
    return new NutritionistDto(
      newNutritionistDto.name,
      newNutritionistDto.lastname,
      newNutritionistDto.specialty,
      newNutritionistDto.professionalLicense);
  }
}
