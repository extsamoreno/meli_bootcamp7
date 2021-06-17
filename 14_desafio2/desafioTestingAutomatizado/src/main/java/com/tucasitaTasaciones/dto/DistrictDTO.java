package com.tucasitaTasaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @NotNull(message = "District name cannot be empty")
    @Size(min=1, max = 45, message = "The length of the name cannot exceed 45 characters.")
    private String district_name;

    @NotNull(message = "District price cannot be empty")
    @DecimalMin(value = "100.0", message = "Minimum price allowed per square meter should be at least u$S100.")
    @DecimalMax(value= "4000.0", message = "Maximum price allowed per square meter cannot exceed U$S4000.")
    private Double district_price;

}
