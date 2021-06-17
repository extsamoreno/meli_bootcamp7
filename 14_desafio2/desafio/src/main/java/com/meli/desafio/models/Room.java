package com.meli.desafio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @NotBlank(message = "The house must have a name")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$", message = "The name of the room must begin with a capital letter")
    @Size(max = 30, message = "The name of the room cannot contain more than 30 characters")
    private String name;

    @Positive
    @Max(value = 25, message = "The width of the room must be less than or equal to 25")
    private Double width;

    @Positive
    @Max(value = 33, message = "The length of the room bust be lees than or equal to 33")
    private Double length;
}
