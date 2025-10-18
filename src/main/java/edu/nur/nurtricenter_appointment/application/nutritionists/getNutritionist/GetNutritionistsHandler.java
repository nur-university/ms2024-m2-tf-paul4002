package edu.nur.nurtricenter_appointment.application.nutritionists.getNutritionist;

import java.util.List;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.utils.NutritionistMapper;
import edu.nur.nurtricenter_appointment.domain.nutritionists.INutritionistRepository;
import edu.nur.nurtricenter_appointment.domain.nutritionists.Nutritionist;

@Component
public class GetNutritionistsHandler implements Command.Handler<GetNutritionistsQuery, List<NutritionistDto>> {

  private final INutritionistRepository nutritionistRepository;
  
  public GetNutritionistsHandler(INutritionistRepository nutritionistRepository) {
    this.nutritionistRepository = nutritionistRepository;
  }

  @Override
  public List<NutritionistDto> handle(GetNutritionistsQuery command) {
    try {
      List<Nutritionist> nutritionists = this.nutritionistRepository.getAll();
      return nutritionists.stream().map(NutritionistMapper::from).toList();
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
