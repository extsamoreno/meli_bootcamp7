package sql.imple.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sql.imple.models.dto.ScheduleDTO;
import sql.imple.services.schedule.IScheduleService;
import java.util.List;

@RestController
@RequestMapping("schedule")
@AllArgsConstructor
public class ScheduleController {

    IScheduleService iScheduleService;

    @PostMapping("/create")
    public String createSchedule(@RequestBody ScheduleDTO scheduleDTO){
        iScheduleService.createSchedule(scheduleDTO);
        return "Schedule created correctly";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        iScheduleService.deleteScheduleById(id);
        return "Schedule deleted correctly";
    }

    @PutMapping("/update")
    public String updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        iScheduleService.updateSchedule(scheduleDTO);
        return "Schedule updated correctly";
    }

    @GetMapping("/getAll")
    public List<ScheduleDTO> getAllSchedule() {
        return iScheduleService.findAllSchedules();
    }

    @GetMapping("/getSchedule/{id}")
    public ScheduleDTO getSchedule(@PathVariable Long id) {
        return iScheduleService.findScheduleById(id);
    }

}
