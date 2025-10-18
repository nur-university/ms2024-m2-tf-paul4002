package edu.nur.nurtricenter_appointment.application.nutritionists.createNutritionist;

public class NewNutritionistDto {
  public String name;
  public String lastname;
  public String specialty;
  public String professionalLicense;
  
  public NewNutritionistDto() {
  }

  public NewNutritionistDto(String name, String lastname, String specialty, String professionalLicense) {
    this.name = name;
    this.lastname = lastname;
    this.specialty = specialty;
    this.professionalLicense = professionalLicense;
  }
}
