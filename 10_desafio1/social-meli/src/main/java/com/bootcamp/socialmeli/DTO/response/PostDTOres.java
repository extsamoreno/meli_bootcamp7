package com.bootcamp.socialmeli.DTO.response;

import com.bootcamp.socialmeli.DTO.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTOres {
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
