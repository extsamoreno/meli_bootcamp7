package com.meli.tu_casita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {

    private Integer id;
    private Integer realStateId;
    private String name;
    private float width;
    private float length;

}
