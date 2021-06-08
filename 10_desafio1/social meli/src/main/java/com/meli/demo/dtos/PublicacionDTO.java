package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {

    private int id_post;
    private Date date;
    private ArrayList <DetalleDTO> detail;
    private String category;
    private Double price;

}

