package com.example.tuCasita.models;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {
    Integer id;
    String name;
    District district;
    List<Enviroment> enviromentList;
}
