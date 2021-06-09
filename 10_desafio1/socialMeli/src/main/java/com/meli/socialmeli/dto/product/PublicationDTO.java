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
public class PublicationDTO {
    private Integer userId;
    private Integer idPost;
    private String date;
    private Product detail;
    private Integer category;
    private double price;

    @Override
    public String toString() {
        return "PublicationDTO{" +
                "userId=" + userId +
                ", id_post=" + idPost +
                ", date='" + date + '\'' +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
