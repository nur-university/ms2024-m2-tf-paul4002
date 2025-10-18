package edu.nur.nurtricenter_appointment.application.appointments.cancelAppointment;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment.ResponseAppointmentDto;

public class CancelAppointmentCommand implements Command<ResponseAppointmentDto> {
  ResponseAppointmentDto responseAppointmentDto;

  public CancelAppointmentCommand(ResponseAppointmentDto responseAppointmentDto) {
    this.responseAppointmentDto = responseAppointmentDto;
  }
}
