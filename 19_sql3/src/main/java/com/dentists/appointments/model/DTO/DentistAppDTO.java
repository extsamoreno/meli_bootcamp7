package com.dentists.appointments.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistAppDTO {
    DentistDTO dentist;
    List<AppointmentDTOWithOutDentist> appointments;

}
