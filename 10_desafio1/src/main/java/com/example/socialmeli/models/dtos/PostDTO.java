package com.example.socialmeli.models.dtos;

import com.example.socialmeli.models.Post;
import com.example.socialmeli.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PostDTO {
    private int postId;
    @JsonFormat(pattern="dd-mm-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PostDTO(Post post) {
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
    }
}
