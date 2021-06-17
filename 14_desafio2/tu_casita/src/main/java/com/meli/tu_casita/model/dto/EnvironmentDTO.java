package com.meli.tu_casita.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {

    private Integer id;
    @NotBlank(message = "Environment name must not be empty.")
    @Size(max = 30, message = "Max length name is 30 characters.")
    private String name;
    @NotNull(message = "Environment width must not be empty.")
    @Max(value = 25, message = "Environment width max 25 mts")
    @Min(value = 1, message = "Environment width min 1 mts")
    private Float width;
    @NotNull(message = "Environment width must not be empty.")
    @Max(value = 33, message = "Environment width max 33 mts")
    @Min(value = 1, message = "Environment width min 1 mts")
    private Float length;
    private Float metersTotal;
    private boolean isTheBiggest;

}
