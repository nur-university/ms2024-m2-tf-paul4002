package edu.nur.nurtricenter_appointment.webapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist.CreateNutritionistCommand;
import edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist.NewNutritionistDto;
import edu.nur.nurtricenter_appointment.application.nutritionists.getNutritionist.GetNutritionistsQuery;
import edu.nur.nurtricenter_appointment.application.nutritionists.getNutritionist.NutritionistDto;
import edu.nur.nurtricenter_appointment.application.utils.NutritionistMapper;

@RestController
@RequestMapping("/api/nutritionist")
public class NutritionistController {
  
  private final  Pipeline pipeline;

  public NutritionistController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @GetMapping
  public List<NutritionistDto> getNutritionist() {
    GetNutritionistsQuery query = new GetNutritionistsQuery();
    return query.execute(pipeline);
  }

  @PostMapping
  public NutritionistDto createNutritionist(@RequestBody NewNutritionistDto nutritionistDto) {
    CreateNutritionistCommand createNutritionistCommand = new CreateNutritionistCommand(NutritionistMapper.from(nutritionistDto));
    return createNutritionistCommand.execute(pipeline);
  }
}
