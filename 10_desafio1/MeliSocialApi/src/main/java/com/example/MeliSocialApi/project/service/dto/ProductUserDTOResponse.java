package com.example.MeliSocialApi.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUserDTOResponse {
    private Integer userId;
    private List<ProductDTO> posts;
}