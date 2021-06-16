package com.meli.desafio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @NotBlank
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$")
    @Size(max = 30, message = "The name of the room cannot contain more than 45 characters")
    private String name;

    @NotBlank
    @Max(25)
    private Integer width;

    @NotBlank
    @Max(33)
    private Integer Length;
}
