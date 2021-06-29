package com.meli.consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tur_id;
    private Date tur_fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prof_id",referencedColumnName = "id")
    private Profesional profesional;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pac_id",referencedColumnName = "pac_id")
    private Paciente paciente;

}
