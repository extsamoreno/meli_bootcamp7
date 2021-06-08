package com.example.socialmeli.DTO;

import com.example.socialmeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
