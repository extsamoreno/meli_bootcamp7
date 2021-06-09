package com.meli.spring_challenge.repository.product;

import com.meli.spring_challenge.model.Product;

public interface ProductRepository {
    Product findProductByID(int productID);
}
