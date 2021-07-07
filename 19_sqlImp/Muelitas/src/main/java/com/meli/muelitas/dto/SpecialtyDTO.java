package com.meli.muelitas.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDTO {

    private Long id;

    @NotBlank(message = "Specialty Name must not be empty.")
    @Size(max = 45, message = "Max length Specialty name is 45 characters.")
    private String name;

    private String description;

    private List<DentistDTO> dentistList;

}
