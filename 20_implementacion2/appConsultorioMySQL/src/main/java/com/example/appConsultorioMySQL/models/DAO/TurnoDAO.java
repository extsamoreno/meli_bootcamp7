package com.example.appConsultorioMySQL.models.DAO;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name= "Turno")
public class TurnoDAO {

    @Id
    private LocalDate fecha;
}
