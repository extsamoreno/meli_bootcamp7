package com.meli.consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

public class Schedule {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "schedule")
    public class Turn {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer sch_id;
        private Date sch_date_in;
        private Date sch_date_out;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(referencedColumnName = "pro_id")
        private Professional sch_professional;
    }
}
