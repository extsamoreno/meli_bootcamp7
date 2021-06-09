package com.socialmeli.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionModel {

    private int userId;
    private int id_post;   //modificar a un mismo criterio.
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private DetailModel detail;
    private int category;
    private double price;

}
