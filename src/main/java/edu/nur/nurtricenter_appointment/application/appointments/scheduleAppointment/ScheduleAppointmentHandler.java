package edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment;

import java.util.UUID;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.utils.ResponseAppointmentMapper;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.AppointmentType;
import edu.nur.nurtricenter_appointment.domain.appointments.IAppointmentRepository;

@Component
public class ScheduleAppointmentHandler implements Command.Handler<ScheduleAppointmentCommand, ResponseAppointmentDto> {
  private final IAppointmentRepository appointmentRepository;
  private final IUnitOfWork unitOfWork;
  
  public ScheduleAppointmentHandler(IAppointmentRepository appointmentRepository, IUnitOfWork unitOfWork) {
    this.appointmentRepository = appointmentRepository;
    this.unitOfWork = unitOfWork;
  }

  @Override
  public ResponseAppointmentDto handle(ScheduleAppointmentCommand request) {
    ResponseAppointmentDto scheduleAppointmentDto = request.scheduleAppointmentDto;
    Appointment appointment = Appointment.schedule(
      UUID.fromString(scheduleAppointmentDto.patientId), 
      UUID.fromString(scheduleAppointmentDto.nutritionistId), 
      scheduleAppointmentDto.scheduleDate, 
      AppointmentType.fromLabel(scheduleAppointmentDto.type)
    );
    this.appointmentRepository.add(appointment);
    this.unitOfWork.commitAsync();
    return ResponseAppointmentMapper.from(appointment);
  }
}
