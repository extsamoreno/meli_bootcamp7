package com.meli.desafio.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    @Size(max = 45, message = "The name of the district cannot contain more than 45 characters")
    @NotEmpty(message = "The district must have a name")
    private String name;
}
