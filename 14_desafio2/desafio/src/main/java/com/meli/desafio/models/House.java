package com.meli.desafio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Size(max = 30, message = "The name of the house cannot contain more than 30 characters")
    @NotBlank
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$")
    private String name;
    private District district;
    private List<@NotBlank Room> rooms;
}
