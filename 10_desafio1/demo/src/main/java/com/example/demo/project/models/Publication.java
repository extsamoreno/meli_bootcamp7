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
    private int id_post, id_user;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private Boolean hasPromo;
    private double discount;

    public Publication() {
        this.hasPromo = false;
        this.discount = 0;
    }
}
