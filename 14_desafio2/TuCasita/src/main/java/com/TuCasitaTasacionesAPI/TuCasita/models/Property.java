package com.TuCasitaTasacionesAPI.TuCasita.models;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private Integer prop_id;
    private String prop_name;
    private Integer district_id;
    private List<Environment> environments;
}
