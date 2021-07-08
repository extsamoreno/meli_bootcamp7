package com.meli.Muelitas.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
public class PatientDTO {

    private String dni;
    private String firstName;
    private String lastName;

}
