package com.appconsultorio.appconsultorio.dtos.request;

import com.appconsultorio.appconsultorio.model.Turn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@Data
@AllArgsConstructor
@Setter
@Getter
public class DentistDTO {

    private int id;
    private String name;
    private String surname;
    private Integer idCalendar;
    Set<Turn> turnSet;

}
