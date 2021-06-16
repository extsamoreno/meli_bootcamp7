package com.desafio.SocialMeli.DTO.Post;

import com.desafio.SocialMeli.DTO.Product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO  implements Comparable<PostDTO>{
    private int id_post;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;

    @Override
    public int compareTo(PostDTO postDTO) {
        return this.getDate().compareTo(postDTO.getDate());
    }
}