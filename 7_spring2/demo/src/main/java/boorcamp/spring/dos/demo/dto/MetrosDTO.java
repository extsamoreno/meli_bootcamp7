package boorcamp.spring.dos.demo.dto;

import boorcamp.spring.dos.demo.entidades.Home;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MetrosDTO {

    private Home home;
    private Double area;



}
