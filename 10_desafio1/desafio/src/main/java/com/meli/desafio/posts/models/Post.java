package com.meli.desafio.posts.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Data
@NoArgsConstructor
public class Post implements Comparable<Post>{
    Integer userId;
    Integer postId;
    Date date;
    Product detail;
    Integer category;
    double price;

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
