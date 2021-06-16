package com.example.tuCasita.dtos;

import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDTO {
    Integer id;
    String name;
    District district;
    List<Enviroment> enviromentList;
}
