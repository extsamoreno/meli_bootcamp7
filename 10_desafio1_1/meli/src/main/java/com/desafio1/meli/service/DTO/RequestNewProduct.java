package com.desafio1.meli.service.DTO;
import com.desafio1.meli.model.*;
import com.desafio1.meli.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestNewProduct {
    private Integer userId;
    private Integer id_post;
    private LocalDate date;
    private Product products;
    private Category category;
    private Double price;
}
