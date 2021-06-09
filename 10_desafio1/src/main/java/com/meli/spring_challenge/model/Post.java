package com.meli.spring_challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post{
    private int userID;
    private int postID;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean hasPromo;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double discount;
}
