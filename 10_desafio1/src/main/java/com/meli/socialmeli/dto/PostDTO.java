package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class PostDTO {

    private int userId;
    private int postId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private ProductDetailDTO detail;
    private int category;
    private double price;

    private boolean hasPromo;
    private double discount;

}
