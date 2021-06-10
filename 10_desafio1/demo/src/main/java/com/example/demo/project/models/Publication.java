package com.example.demo.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class Publication {
    private int post_id, user_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private Boolean has_promo;
    private double discount;

    public Publication() {
        this.has_promo = false;
        this.discount = 0;
    }
}
