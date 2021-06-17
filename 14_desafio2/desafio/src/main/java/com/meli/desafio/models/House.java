package com.meli.desafio.models;

import com.meli.desafio.models.dto.DistrictDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private Integer id;

    @Size(max = 30, message = "The name of the house cannot contain more than 30 characters")
    @NotBlank(message = "The house must have a name")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$", message = "The name of the house must begin with a capital letter")
    private String name;

    @NotNull(message = "The house must be have a district")
    private Integer districtId;

    @Valid
    @Size(min = 1, message = "The house mut be have a room")
    private List<Room> rooms;
}