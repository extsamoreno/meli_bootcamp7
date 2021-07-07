package com.meli.muelitas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistAvailabilityId implements Serializable {

    private Long dentistId;

    private String dayOfWeek;

}
