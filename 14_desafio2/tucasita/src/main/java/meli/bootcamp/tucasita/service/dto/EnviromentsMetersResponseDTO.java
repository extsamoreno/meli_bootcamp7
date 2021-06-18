package meli.bootcamp.tucasita.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnviromentsMetersResponseDTO {

    private String prop_name;
    private List<EnvironmentDTO> environment;
}
