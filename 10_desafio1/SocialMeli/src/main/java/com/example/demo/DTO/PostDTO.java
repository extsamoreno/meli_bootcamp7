package com.example.demo.DTO;


import com.example.demo.entities.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;

}
