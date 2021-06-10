package com.desafio1.meli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private Integer id;
    private User user;
    private LocalDate date;
    private Product product;
    private Category category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
