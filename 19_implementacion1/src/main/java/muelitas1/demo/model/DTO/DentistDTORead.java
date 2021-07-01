package muelitas1.demo.model.DTO;

import lombok.Data;
import muelitas1.demo.model.Schedule;

@Data
public class DentistDTORead {
    Long id;
    String name;
    String surname;
    String dni;
}
