package com.example.socialmeli.models;

import com.example.socialmeli.models.dtos.PostDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Data
public class Post {
    private int postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post (PostDTO postDTO){
        this.postId = postDTO.getPostId();
        this.date = postDTO.getDate();
        this.detail = postDTO.getDetail();
        this.category = postDTO.getCategory();
        this.price = postDTO.getPrice();
        this.hasPromo = postDTO.isHasPromo();
        this.discount = postDTO.getDiscount();
    }
}
