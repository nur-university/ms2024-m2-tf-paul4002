package edu.nur.nurtricenter_appointment.application.appointments.attendAppointment;

import java.util.UUID;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.utils.AppointmentMapper;
import edu.nur.nurtricenter_appointment.application.utils.DiagnosisMapper;
import edu.nur.nurtricenter_appointment.application.utils.MealPlanMapper;
import edu.nur.nurtricenter_appointment.application.utils.MeasurementMapper;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.IAppointmentRepository;
import edu.nur.nurtricenter_appointment.domain.mealplans.IMealPlanRepository;
import edu.nur.nurtricenter_appointment.domain.mealplans.MealPlan;

@Component
public class AttendAppointmentHandler implements Command.Handler<AttendAppointmentCommand, AppointmentDto> {
  private final IAppointmentRepository appointmentRepository;
  private final IMealPlanRepository mealPlanRepository;
  private final IUnitOfWork unitOfWork;
  
  

  public AttendAppointmentHandler(IAppointmentRepository appointmentRepository, IMealPlanRepository mealPlanRepository,
      IUnitOfWork unitOfWork) {
    this.appointmentRepository = appointmentRepository;
    this.mealPlanRepository = mealPlanRepository;
    this.unitOfWork = unitOfWork;
  }

  @Override
  public AppointmentDto handle(AttendAppointmentCommand request) {
    RequestAttendAppointmentDto appointmentDto = request.requestAttendAppointmentDto;
    Appointment appointment = this.appointmentRepository.GetById(UUID.fromString(appointmentDto.id));
    appointment.attend(
      appointmentDto.notes, 
      MeasurementMapper.from(appointmentDto.measurementDto), 
      DiagnosisMapper.from(appointmentDto.diagnosisDto));
    // this.appointmentRepository.attend(appointment);
    MealPlan mealPlan = MealPlanMapper.from(request.requestAttendAppointmentDto.mealPlanDto);
    mealPlan.setAppointmentId(appointment.getId());
    this.mealPlanRepository.add(mealPlan);
    this.unitOfWork.commitAsync();
    return AppointmentMapper.from(appointment);
  }
}
