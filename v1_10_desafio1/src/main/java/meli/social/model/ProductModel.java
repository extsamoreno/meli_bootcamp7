package meli.social.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductModel {
    private int productId;
    private String productName, type, brand, color, notes;
}
