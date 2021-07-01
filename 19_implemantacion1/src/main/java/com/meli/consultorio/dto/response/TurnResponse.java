package com.meli.consultorio.dto.response;

import com.meli.consultorio.model.Patient;
import com.meli.consultorio.model.Professional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnResponse {
    private Integer sch_id;
    private Date sch_date;
    private Integer sch_patient_id;
    private Integer sch_profesional_id;
}
