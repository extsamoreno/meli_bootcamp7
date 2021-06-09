package com.springChallenge.api.controller.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class PostDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int userId;
    @JsonProperty("id_post")
    private int idPost;
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
}
