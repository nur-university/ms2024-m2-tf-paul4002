package edu.nur.nurtricenter_appointment.application.appointments.scheduleAppointment;

import an.awesome.pipelinr.Command;

public class ScheduleAppointmentCommand implements Command<ResponseAppointmentDto> {
  ResponseAppointmentDto scheduleAppointmentDto;

  public ScheduleAppointmentCommand(ResponseAppointmentDto scheduleAppointmentDto) {
    this.scheduleAppointmentDto = scheduleAppointmentDto;
  }
}
