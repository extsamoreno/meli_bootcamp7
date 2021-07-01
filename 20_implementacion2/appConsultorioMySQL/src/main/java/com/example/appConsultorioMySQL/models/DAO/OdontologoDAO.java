package com.example.appConsultorioMySQL.models.DAO;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Odontologo")
public class OdontologoDAO {

    private String nombre;
    private String apellido;

    @Id
    private Long dni;

    @OneToOne(mappedBy= "id", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private AgendaDAO agenda;
}
