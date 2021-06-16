package com.TuCasitaTasacionesAPI.TuCasita.dtos;

import com.TuCasitaTasacionesAPI.TuCasita.models.Environment;
import lombok.Data;
import java.util.List;

@Data
public class PropertyDTO {
    private String prop_name;
    private Integer district_id;
    private List<Environment> environments;
}
