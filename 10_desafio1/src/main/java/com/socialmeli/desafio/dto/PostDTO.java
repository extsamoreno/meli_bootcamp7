package com.socialmeli.desafio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.desafio.model.DetailModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter


public class PostDTO {

    private int userId;
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private DetailModel detail;
    private int category;
    private double price;


}