package edu.nur.nurtricenter_appointment.application.appointments.notAttendedAppointment;

import java.util.UUID;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment.ResponseAppointmentDto;
import edu.nur.nurtricenter_appointment.application.utils.ResponseAppointmentMapper;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.IAppointmentRepository;

@Component
public class NotAttendedAppointmentHandler implements Command.Handler<NotAttendedAppointmentCommand, ResponseAppointmentDto> {
  private final IAppointmentRepository appointmentRepository;
  private final IUnitOfWork unitOfWork;
  
  public NotAttendedAppointmentHandler(IAppointmentRepository appointmentRepository, IUnitOfWork unitOfWork) {
    this.appointmentRepository = appointmentRepository;
    this.unitOfWork = unitOfWork;
  }

  @Override
  public ResponseAppointmentDto handle(NotAttendedAppointmentCommand request) {
    Appointment appointment = new Appointment(UUID.fromString(request.responseAppointmentDto.id));
    // appointment = this.appointmentRepository.notAttended(appointment.getId());
    this.unitOfWork.commitAsync();
    return ResponseAppointmentMapper.from(appointment);
  }
}
