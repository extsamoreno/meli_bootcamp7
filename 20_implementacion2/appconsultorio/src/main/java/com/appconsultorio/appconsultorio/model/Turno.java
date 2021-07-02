package com.appconsultorio.appconsultorio.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Integer id;

    @Column(name = "fecha")
    @JsonFormat(pattern="yyyy-mm-dd")
    Date fecha;

    @Column(name = "estado")
    String estado;

    @Column(name = "fecha_reprogramada")
    Date fechaReprogramada;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_odontologo", referencedColumnName = "id_odontologo")
    private Odontologo odontologo;

}
