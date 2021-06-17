package com.meli.tu_casita.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RealStateInDTO {

    @NotBlank(message = "Name must not be empty.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "Name must be start with Uppercase.")
    @Size(max = 30, message = "Max length name is 30 characters.")
    private String name;
    @NotNull
    private Integer districtId;
    @NotEmpty(message = "Environment list must not be empty")
    private List<@Valid EnvironmentDTO> environments;
}
