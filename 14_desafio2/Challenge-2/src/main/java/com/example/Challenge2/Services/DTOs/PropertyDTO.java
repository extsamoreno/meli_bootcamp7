package com.example.Challenge2.Services.DTOs;

import com.example.Challenge2.Models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class PropertyDTO extends StructureDTO{

    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z][0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    private String name;
    private List<@Valid RoomDTO> rooms;
    private Long districtId;

}
