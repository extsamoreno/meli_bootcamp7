package com.bootcamp.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostFollowedDTO {
    private Integer id_postId;
    private LocalDate date;
    private ProductDTO detail;
    private String category;
    private double price;
}
