package com.bootcamp.socialmeli.DTO.request;

import com.bootcamp.socialmeli.DTO.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTOreq {
    private int userId;
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
}
