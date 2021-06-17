package meli.bootcamp.tucasita.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    private String prop_name;
    private Distric district;
    private List<Environment> environments;
}
