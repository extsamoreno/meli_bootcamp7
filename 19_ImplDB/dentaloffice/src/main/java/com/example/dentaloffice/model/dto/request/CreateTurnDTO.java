package com.example.dentaloffice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTurnDTO {

    @NotEmpty(message = "Empty date not allowed.")
    private String date;

    @NotEmpty(message = "Empty dni not allowed.")
    private String patientDni;

    @NotEmpty(message = "Empty dni not allowed.")
    private String dentistDni;
}
