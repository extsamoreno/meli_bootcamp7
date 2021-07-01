package com.example.appConsultorioMySQL.models.DAO;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name= "Agenda")
public class AgendaDAO {

    @Id
    @GeneratedValue
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name= "id")
    private int id;

    @Column(name= "turnos_fecha")
    @OneToMany(cascade= CascadeType.ALL )
    @JoinColumn(name= "fecha")
    private List<TurnoDAO> turnos;

}
