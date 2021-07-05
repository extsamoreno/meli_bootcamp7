package com.meli.consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turn")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tur_id;
    private Date tur_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "pat_id")
    private Patient tur_patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "pro_id")
    private Professional tur_professional;
}
