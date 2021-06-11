package com.digitalhouse.obtenerdiploma.service.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;




@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {

    @NotNull(message = "nombre de estudiante no puede ser nullo")
    @NotEmpty(message = "nombre de estudiante debe contener caracteres")
    @Size(max = 50, message = "El nombre debería tener menos de 50 caracteres")
    @Pattern(regexp = "^[A-Z].*" , message = "nombre del estudiante debe comenzar con mayuscula")
    private String name;


    @NotEmpty(message = "la lista de subjects no puede estar vacia")
    @Valid private List<SubjectDTO> subjects;


}
