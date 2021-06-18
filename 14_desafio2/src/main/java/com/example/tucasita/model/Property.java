package com.example.tucasita.model;

import lombok.*;

import java.util.List;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Property {
    private int propId;
    private String propName;
    private String districtName;
    private List<Environment> environments;
}
