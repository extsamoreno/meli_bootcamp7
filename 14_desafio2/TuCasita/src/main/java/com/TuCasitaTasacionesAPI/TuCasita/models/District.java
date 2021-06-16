package com.TuCasitaTasacionesAPI.TuCasita.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    private Integer district_id;
    private String district_name;
    private Double district_price;
}
