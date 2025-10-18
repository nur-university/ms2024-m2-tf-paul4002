package edu.nur.nurtricenter_appointment.application.appointments.attendAppointment;

import an.awesome.pipelinr.Command;

public class AttendAppointmentCommand implements Command<AppointmentDto> {
  RequestAttendAppointmentDto requestAttendAppointmentDto;

  public AttendAppointmentCommand(RequestAttendAppointmentDto requestAttendAppointmentDto) {
    this.requestAttendAppointmentDto = requestAttendAppointmentDto;
  }
}
