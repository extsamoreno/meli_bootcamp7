package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.socialmeli.model.Product;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPostDTO {
    private Integer userId;
    private Integer postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private Integer category;
    private double price;
}
