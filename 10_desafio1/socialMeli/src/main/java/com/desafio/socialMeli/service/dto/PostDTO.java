package com.desafio.socialMeli.service.dto;

import com.desafio.socialMeli.repository.entities.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private Integer userId;
    private Integer id_post;
    private String date;//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Product detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private float discount;

    public static Date stringToDate(String stringDate){
        Integer day = Integer.parseInt(stringDate.substring(0, 2));
        Integer month = Integer.parseInt(stringDate.substring(3, 5));
        Integer year = Integer.parseInt(stringDate.substring(6, 10));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        return calendar.getTime();
    }
}
