package com.socialmeli.desafio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.desafio.model.DetailModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter


public class PublicacionDTO {

    private int userId;
    private int id_post;
    private Date date;
    private DetailModel detail;
    private int category;
    private double price;


}
