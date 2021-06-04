package meli.star.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class NombreResponseDTO {
    private List<String> nombres;
}
