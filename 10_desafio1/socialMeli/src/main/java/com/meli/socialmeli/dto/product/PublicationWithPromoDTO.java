package com.meli.socialmeli.dto.product;

import com.meli.socialmeli.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationWithPromoDTO extends PublicationDTO {

    private boolean hasPromo;
    private double discount;

    public PublicationWithPromoDTO(Integer userId, Integer idPost, String date, Product detail, Integer category, double price, boolean hasPromo, double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PublicationWithPromoDTO{" +"userId=" + getUserId() +
                ", id_post=" + getIdPost() +
                ", date='" + getDate() + '\'' +
                ", detail=" + getDetail() +
                ", category=" + getCategory() +
                ", price=" + getPrice() +
                '}'+
                "hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}
