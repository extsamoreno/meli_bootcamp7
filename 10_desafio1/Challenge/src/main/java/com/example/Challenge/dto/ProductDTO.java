package com.example.Challenge.dto;

import com.example.Challenge.model.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements  Comparable<LocalDate> {
    private Integer idPost;
    private String date;
    private ProductDetail detail;
    private Integer category;
    private double price;
    private boolean hasPromo;
    private double discount;


    //Constructor for products without promo
    public ProductDTO(Integer idPost, String date, ProductDetail detail, Integer category, double price) {
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }


    //Convert String to LocalDate
    public LocalDate getDateFromString(){
        LocalDate resultDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        return resultDate;
    }

    @Override
    public int compareTo(LocalDate o) {
        if(getDateFromString().isBefore(o)){
            return -1;
        }
        else if (getDateFromString().isAfter(o)){
            return 1;
        }
        return 0;
    }
}
