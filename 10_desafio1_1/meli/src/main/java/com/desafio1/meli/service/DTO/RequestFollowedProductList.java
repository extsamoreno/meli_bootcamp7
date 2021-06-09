package com.desafio1.meli.service.DTO;

import com.desafio1.meli.model.Category;
import com.desafio1.meli.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestFollowedProductList {
    private Integer userId;
    private ArrayList<Publication> posts;

}
