package com.example.tuCasita.dtos;

import com.example.tuCasita.models.District;

import java.util.List;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDTO {
    Integer id;

    @NotBlank(message = "The name of the property can not be empty.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The name of the property must start in uppercase.")
    @Size(max = 30, message = "The length of the name cannot exceed 30 characters.")
    private String name;
    private Integer districtId;
    private List<@Valid EnviromentDTO> enviromentList;
}
