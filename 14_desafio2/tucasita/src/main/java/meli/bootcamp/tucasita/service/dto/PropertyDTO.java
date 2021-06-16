package meli.bootcamp.tucasita.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.bootcamp.tucasita.model.Distric;
import meli.bootcamp.tucasita.model.Environment;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyDTO {

    private String prop_name;
    private Distric distric;
    private List<Environment> environments;
}
