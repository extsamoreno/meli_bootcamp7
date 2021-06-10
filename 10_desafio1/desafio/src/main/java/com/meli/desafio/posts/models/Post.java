package com.meli.desafio.posts.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Comparable<Post>{
    private Integer userId;
    private Integer postId;
    private Date date;
    private Product detail;
    private Integer category;
    private double price;
    private boolean hasPromo = false;
    private double discount = 0.00;

    @Override
    public int compareTo(Post o) {
        Date date1 = this.getDate();
        Date date2 = o.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate localDate1 = LocalDate.parse(dateFormat.format(date1));
        LocalDate localDate2 = LocalDate.parse(dateFormat.format(date2));
        Period period = Period.between(localDate1, localDate2);

        if (period.getYears() != 0) return period.getYears();
        if (period.getMonths() != 0) return period.getMonths();
        return period.getDays();
    }
}
