package com.example.dentaloffice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnDTO {

    private String date;
    private String dentistFullName;
    private String patientFullName;

}
