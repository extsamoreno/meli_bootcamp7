package com.meli.spring_challenge.service.dto;

import com.meli.spring_challenge.model.Product;
import com.meli.spring_challenge.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto extends User {
        private List<Product> productList;
}
