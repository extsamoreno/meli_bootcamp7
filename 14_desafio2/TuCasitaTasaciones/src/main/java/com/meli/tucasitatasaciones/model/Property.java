package com.meli.tucasitatasaciones.model;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Property {
    private Integer id;
    private String name;
    private District district;
    private List<Environment> environments;
}
