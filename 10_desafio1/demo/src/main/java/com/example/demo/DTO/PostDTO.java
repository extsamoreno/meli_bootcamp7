package com.example.demo.DTO;

import lombok.Data;

import java.util.Date;


@Data
public class PostDTO implements Comparable {

    private Integer userId;
    private Integer idPost;
    private Date date;
    private ProductDTO detail;
    private Integer category;
    private double price;


    @Override
    public int compareTo(Object o) {
        Integer respuesta = 0;
        if(this.date.after((Date)o))
            respuesta = 1;
        else if(this.date.before((Date)o))
            respuesta = -1;
        return respuesta;
    }
}
