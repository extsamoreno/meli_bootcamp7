package sql.imple.services.schedule;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sql.imple.models.Dentist;
import sql.imple.models.Schedule;
import sql.imple.models.dto.DentistDTO;
import sql.imple.models.dto.ScheduleDTO;
import sql.imple.repositories.IScheduleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{

    IScheduleRepository iScheduleRepository;
    ModelMapper mapper;

    @Override
    public void createSchedule(ScheduleDTO scheduleDTO) {
        iScheduleRepository.save(mapper.map(scheduleDTO, Schedule.class));
    }

    @Override
    public void deleteScheduleById(Long id) {
        iScheduleRepository.deleteById(id);
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        iScheduleRepository.save(mapper.map(scheduleDTO, Schedule.class));
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        List<Schedule> schedules = iScheduleRepository.findAll();
        return schedules.stream().map(schedule -> mapper.map(schedule, ScheduleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO findScheduleById(Long id) {
        Optional<Schedule> item = iScheduleRepository.findById(id);
        return item.map(schedule -> mapper.map(schedule, ScheduleDTO.class)).orElse(null);

    }
}
