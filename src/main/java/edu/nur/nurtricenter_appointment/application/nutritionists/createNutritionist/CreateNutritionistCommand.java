package edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.nutritionists.getNutritionist.NutritionistDto;

public class CreateNutritionistCommand implements Command<NutritionistDto> {
  NutritionistDto nutritionistDto;

  public CreateNutritionistCommand(NutritionistDto nutritionistDto) {
    this.nutritionistDto = nutritionistDto;
  }
}
