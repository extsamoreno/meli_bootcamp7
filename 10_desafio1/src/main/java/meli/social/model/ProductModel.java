package meli.social.model;

import lombok.Data;

@Data
public class ProductModel {
    private int productId;
    private String productName, type, brand, color, notes;
}
