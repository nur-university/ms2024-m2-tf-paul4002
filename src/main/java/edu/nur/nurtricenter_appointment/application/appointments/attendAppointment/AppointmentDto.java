package edu.nur.nurtricenter_appointment.application.appointments.attendAppointment;

import java.time.LocalDateTime;

public class AppointmentDto {
  public String id;
  public String patientId;
  public String nutritionistId;
  public String type;
  public LocalDateTime creationDate;
  public LocalDateTime scheduleDate;
  public LocalDateTime cancelDate;
  public String status;
  public String attendance;
  public String notes;
  public MeasurementDto measurementDto;
  public DiagnosisDto diagnosisDto;
  
  public AppointmentDto() {
  }

  
  public AppointmentDto(String id, String patientId, String nutritionistId, String type, LocalDateTime creationDate,
      LocalDateTime scheduleDate, LocalDateTime cancelDate, String status, String attendance, String notes) {
    this.id = id;
    this.patientId = patientId;
    this.nutritionistId = nutritionistId;
    this.type = type;
    this.creationDate = creationDate;
    this.scheduleDate = scheduleDate;
    this.cancelDate = cancelDate;
    this.status = status;
    this.attendance = attendance;
    this.notes = notes;
  }

  public AppointmentDto(String id, String patientId, String nutritionistId, String type, LocalDateTime creationDate,
      LocalDateTime scheduleDate, LocalDateTime cancelDate, String status, String attendance, String notes,
      MeasurementDto measurementDto, DiagnosisDto diagnosisDto) {
    this.id = id;
    this.patientId = patientId;
    this.nutritionistId = nutritionistId;
    this.type = type;
    this.creationDate = creationDate;
    this.scheduleDate = scheduleDate;
    this.cancelDate = cancelDate;
    this.status = status;
    this.attendance = attendance;
    this.notes = notes;
    this.measurementDto = measurementDto;
    this.diagnosisDto = diagnosisDto;
  }
}
