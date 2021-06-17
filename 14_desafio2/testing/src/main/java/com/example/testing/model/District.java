package com.example.testing.model;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @NotBlank(message = "District name cannot be void.")
    @Size(max = 45, message = "District name length cannot surpass 30 characters.")
    private String name;

    @NotNull(message = "District price cannot be void.")
    @DecimalMax(value = "4000.0", message = "District price cannot be over 4000 U$S")
    private Double price;
}
