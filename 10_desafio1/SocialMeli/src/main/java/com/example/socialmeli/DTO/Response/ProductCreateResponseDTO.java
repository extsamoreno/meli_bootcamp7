package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponseDTO {
    private ProductDTO product;
}
