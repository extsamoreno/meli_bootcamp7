package com.meli.muelitas.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "dentist_availabilities")
public class DentistAvailability implements Serializable {

    @EmbeddedId
    DentistAvailabilityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    @MapsId("dentistId")
    private Dentist dentist;

    private LocalTime dayStart;

    private LocalTime DayEnd;

    private LocalTime breakStart;

    private LocalTime breakEnd;


}
