package com.reto1.demo.Model.DTO;

import com.reto1.demo.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO {
    boolean hasPromo;
    double discount;

    public PromoPostDTO(int id_post, Date date, Product detail, int category, double price, boolean hasPromo, double discount) {
        super(id_post, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
