package sql.imple.services.appointment;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sql.imple.models.Appointment;
import sql.imple.models.dto.AppointmentDTO;
import sql.imple.repositories.IAppointmentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService{

    IAppointmentRepository iAppointmentRepository;
    ModelMapper mapper;

    @Override
    public void createAppointment(AppointmentDTO appointmentDTO) {
        iAppointmentRepository.save(mapper.map(appointmentDTO, Appointment.class));
    }

    @Override
    public void deleteAppointmentById(Long id) {
        iAppointmentRepository.deleteById(id);
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        iAppointmentRepository.save(mapper.map(appointmentDTO , Appointment.class));
    }

    @Override
    public List<AppointmentDTO> findAllAppointments() {
        List<Appointment> appointments = iAppointmentRepository.findAll();
        return appointments.stream().map(appointment -> mapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findAppointmentById(Long id) {
        Optional<Appointment> item = iAppointmentRepository.findById(id);
        return item.map(appointment -> mapper.map(appointment, AppointmentDTO.class)).orElse(null);
    }
}
