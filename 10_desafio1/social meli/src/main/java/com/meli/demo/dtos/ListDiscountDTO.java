package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data@AllArgsConstructor@NoArgsConstructor
public class ListDiscountDTO {
    private int id;
    private String userName;
    private ArrayList<PostDTO> posts;
}
