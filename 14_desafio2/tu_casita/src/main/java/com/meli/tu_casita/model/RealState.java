package com.meli.tu_casita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealState {

    private Integer id;
    private String name;
    private int districtId;

}
