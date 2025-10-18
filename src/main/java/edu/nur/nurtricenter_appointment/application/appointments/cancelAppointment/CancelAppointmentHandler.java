package edu.nur.nurtricenter_appointment.application.appointments.cancelAppointment;

import java.util.UUID;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment.ResponseAppointmentDto;
import edu.nur.nurtricenter_appointment.application.utils.ResponseAppointmentMapper;
import edu.nur.nurtricenter_appointment.core.abstractions.IUnitOfWork;
import edu.nur.nurtricenter_appointment.domain.appointments.Appointment;
import edu.nur.nurtricenter_appointment.domain.appointments.IAppointmentRepository;

@Component
public class CancelAppointmentHandler implements Command.Handler<CancelAppointmentCommand, ResponseAppointmentDto> {
  private final IAppointmentRepository appointmentRepository;
  private final IUnitOfWork unitOfWork;
  
  public CancelAppointmentHandler(IAppointmentRepository appointmentRepository, IUnitOfWork unitOfWork) {
    this.appointmentRepository = appointmentRepository;
    this.unitOfWork = unitOfWork;
  }

  @Override
  public ResponseAppointmentDto handle(CancelAppointmentCommand request) {
    Appointment appointment = new Appointment(UUID.fromString(request.responseAppointmentDto.id));
    appointment = this.appointmentRepository.cancel(appointment.getId());
    this.unitOfWork.commitAsync();
    return ResponseAppointmentMapper.from(appointment);
  }
}
