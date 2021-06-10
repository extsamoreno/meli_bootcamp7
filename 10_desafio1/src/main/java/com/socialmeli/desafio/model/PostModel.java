package com.socialmeli.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {

    private int userId;
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private DetailModel detail;
    private int category;
    private double price;
    private boolean hasPromo= false;
    private double discount;


}
