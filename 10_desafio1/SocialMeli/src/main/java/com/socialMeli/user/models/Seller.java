package com.socialMeli.user.models;

import com.socialMeli.product.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User {

    private ArrayList<User> followers;
    private ArrayList<Product> products;
}
