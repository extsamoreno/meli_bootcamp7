package sql.imple.models.dto;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    private String schedule_day;
    private Date schedule_from;
    private Date schedule_to;
    private Long dentist_id;
}
