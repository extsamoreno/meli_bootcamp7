package com.meli.socialmeli.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private Integer userId;
    private Integer id_post;
    private Date date;
    private Product detail;
    private Integer category;
    private double price;

    @Override
    public String toString() {
        return "Publication{" +
                "userId=" + userId +
                ", id_post=" + id_post +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
