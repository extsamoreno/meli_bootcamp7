package com.meli.socialmeli.domain;

import lombok.*;

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

    @Override
    public String toString() {
        return "Publication{" +
                "userId=" + userId +
                ", id_post=" + idPost +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
