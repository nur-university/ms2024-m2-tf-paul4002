package edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.nutritionists.getNutritionist.NutritionistDto;
import edu.nur.nurtricenter_appointment.application.utils.NutritionistMapper;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.domain.nutritionists.INutritionistRepository;
import edu.nur.nurtricenter_appointment.domain.nutritionists.Nutritionist;
import edu.nur.nurtricenter_appointment.domain.nutritionists.NutritionistSpecialty;

@Component
public class CreateNutritionistHandler implements Command.Handler<CreateNutritionistCommand, NutritionistDto> {
  private final INutritionistRepository nutritionistRepository;
  private final IUnitOfWork unitOfWork;

  public CreateNutritionistHandler(INutritionistRepository nutritionistRepository, IUnitOfWork unitOfWork) {
    this.nutritionistRepository = nutritionistRepository;
    this.unitOfWork = unitOfWork;
  }

  @Override
  public NutritionistDto handle(CreateNutritionistCommand request) {
    NutritionistDto nutritionistDto = request.nutritionistDto;
    Nutritionist nutritionist = new Nutritionist(
      nutritionistDto.name, 
      nutritionistDto.lastname, 
      NutritionistSpecialty.fromLabel(nutritionistDto.specialty), 
      nutritionistDto.professionalLicense);
    this.nutritionistRepository.Add(nutritionist);
    this.unitOfWork.commitAsync();
    return NutritionistMapper.from(nutritionist);
  }
}
