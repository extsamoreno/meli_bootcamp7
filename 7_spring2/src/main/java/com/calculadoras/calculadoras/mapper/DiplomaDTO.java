package com.calculadoras.calculadoras.mapper;
import com.calculadoras.calculadoras.entity.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiplomaDTO {
    String mensaje;
    int promedio;
    Alumno alumno;
}
