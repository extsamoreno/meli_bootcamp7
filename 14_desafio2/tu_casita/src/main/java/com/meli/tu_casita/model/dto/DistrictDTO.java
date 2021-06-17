package com.meli.tu_casita.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    private Integer id;
    @NotBlank(message = "District Name must not be empty.")
    @Size(max = 45, message = "Max length District name is 45 characters.")
    private String name;
    @NotNull(message = "District price must not be empty.")
    @Max(value = 4000, message = "District price must be less than US4000")
    @Min(value = 50, message = "District price must be greater than US50")
    private Float price;

}
