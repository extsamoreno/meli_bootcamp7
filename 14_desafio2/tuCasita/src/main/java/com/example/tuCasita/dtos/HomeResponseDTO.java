package com.example.tuCasita.dtos;

import com.example.tuCasita.models.District;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponseDTO {
    private Integer id;
    private String name;
    private District district;
    private List<EnviromentDTO> enviromentList;
}
