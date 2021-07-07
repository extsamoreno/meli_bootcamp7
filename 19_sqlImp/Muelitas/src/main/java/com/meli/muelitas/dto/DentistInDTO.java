package com.meli.muelitas.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DentistInDTO {

    @NotBlank(message = "Tag must not be empty")
    private String tag;
    @NotBlank(message = "Name must not be empty")
    private String name;
    @NotNull(message = "specialtyId must not be empty")
    private Long specialtyId;

}
