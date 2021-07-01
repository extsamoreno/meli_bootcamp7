package com.example.appConsultorioMySQL.models.DAO;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Paciente")
public class PacienteDAO {

    @Id
    private Long dni;

    private String nombre;
    private String apellido;

    @OneToOne(mappedBy= "fecha", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private TurnoDAO turno;
}
