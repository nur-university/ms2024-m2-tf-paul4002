package edu.nur.nurtricenter_appointment.application.appointments.attendAppointment;

public class RequestAttendAppointmentDto {
  public String id;
  public String notes;
  public MeasurementDto measurementDto;
  public DiagnosisDto diagnosisDto;
  public MealPlanDto mealPlanDto;
  
  public RequestAttendAppointmentDto() {
  }

  public RequestAttendAppointmentDto(String id, String notes, MeasurementDto measurementDto,
      DiagnosisDto diagnosisDto, MealPlanDto mealPlanDto) {
    this.id = id;
    this.notes = notes;
    this.measurementDto = measurementDto;
    this.diagnosisDto = diagnosisDto;
    this.mealPlanDto = mealPlanDto;
  }
}
