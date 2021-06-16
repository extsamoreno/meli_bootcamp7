package com.example.tuCasita.dtos;

import com.example.tuCasita.models.District;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponseDTO {
    Integer id;
    String name;
    District district;
    List<EnviromentDTO> enviromentList;
}
