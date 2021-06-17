package com.desafiotesting.desafiotesting.models;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    int id;
    String name;
    District district;
    List<Enviroment> enviroments;
}
