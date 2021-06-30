package com.meli.AppConsultorioMySQL.models.DTO;

import com.meli.AppConsultorioMySQL.models.Schedule;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
public class DentistDTO {


    private String dni;
    private String name;
    private String lastname;

}
