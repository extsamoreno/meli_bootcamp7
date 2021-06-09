package com.meli.socialmeli.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private Integer userId;
    private Integer idPost;
    private LocalDate date;
    private Product detail;
    private Integer category;
    private double price;
    private boolean hasPromo;
    private double discount;

    @Override
    public String toString() {
        return "Publication{" +
                "userId=" + userId +
                ", idPost=" + idPost +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                ", hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}
