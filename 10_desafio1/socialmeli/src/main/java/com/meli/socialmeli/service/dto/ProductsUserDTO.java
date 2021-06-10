package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductsUserDTO {
    private Integer userId;
    private String userName;
    private List<PostDTO> products;

}
