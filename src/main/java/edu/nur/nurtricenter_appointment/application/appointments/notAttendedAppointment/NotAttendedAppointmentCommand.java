package edu.nur.nurtricenter_appointment.application.appointments.notAttendedAppointment;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment.ResponseAppointmentDto;

public class NotAttendedAppointmentCommand implements Command<ResponseAppointmentDto> {
  ResponseAppointmentDto responseAppointmentDto;

  public NotAttendedAppointmentCommand(ResponseAppointmentDto responseAppointmentDto) {
    this.responseAppointmentDto = responseAppointmentDto;
  }
}
