package edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist;

import java.util.UUID;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.core.results.ResultWithValue;
import edu.nur.nurtricenter_appointment.domain.nutritionists.INutritionistRepository;
import edu.nur.nurtricenter_appointment.domain.nutritionists.Nutritionist;
import edu.nur.nurtricenter_appointment.domain.nutritionists.NutritionistSpecialty;

@Component
public class CreateNutritionistHandler implements Command.Handler<CreateNutritionistCommand, ResultWithValue<UUID>> {
  private final INutritionistRepository nutritionistRepository;
  private final IUnitOfWork unitOfWork;

  public CreateNutritionistHandler(INutritionistRepository nutritionistRepository, IUnitOfWork unitOfWork) {
    this.nutritionistRepository = nutritionistRepository;
    this.unitOfWork = unitOfWork;
  }

  @Override
  public ResultWithValue<UUID> handle(CreateNutritionistCommand request) {
    Nutritionist nutritionist = new Nutritionist(
        request.name(), 
        request.lastname(), 
        NutritionistSpecialty.fromLabel(request.specialty()), 
        request.professionalLicense()
      );
    this.nutritionistRepository.Add(nutritionist)  ;
    this.unitOfWork.commitAsync();
    return ResultWithValue.success(nutritionist.getId());
  }
}
