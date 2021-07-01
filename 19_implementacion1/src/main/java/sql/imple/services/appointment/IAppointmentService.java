package sql.imple.services.appointment;

import sql.imple.models.dto.AppointmentDTO;

import java.util.List;

public interface IAppointmentService {
    void createAppointment(AppointmentDTO appointmentDTO);

    void deleteAppointmentById(Long id);

    void updateAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> findAllAppointments();

    AppointmentDTO findAppointmentById(Long id);
}
