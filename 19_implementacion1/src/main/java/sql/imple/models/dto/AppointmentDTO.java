package sql.imple.models.dto;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Date appointment_date;
    private Long patient_id;
    private Long dentist_id;
}
