package com.example.Challenge.dto;

import com.example.Challenge.model.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements  Comparable<LocalDate> {
    private Integer idPost;
    private String date;
    private ProductDetail detail;
    private Integer category;
    private Double price;

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
