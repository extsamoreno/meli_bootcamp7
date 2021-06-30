package com.meli.AppConsultorioMySQL.models.DTO;

import com.meli.AppConsultorioMySQL.models.Apoointment;
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
    private String name;
    private String lastname;

}
