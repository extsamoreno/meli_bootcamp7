package com.tucasitaTasaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private Integer propId;

    @NotNull(message = "Property name cannot be empty")
    @Size(min=4, message = "The length of the name should have at least 4 characters." )
    @Size(max = 30, message = "The length of the name cannot exceed 30 characters.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "Property name must start with a capital letter" )
    private String prop_name;

    @NotNull(message = "District name cannot be empty")
    @Size(min = 4, message = "The length of the name cannot exceed 45 characters.")
    @Size(max = 45, message = "The length of the name cannot exceed 45 characters.")
    private String districtName;
    private List<EnvironmentDTO> environmentList;


}
