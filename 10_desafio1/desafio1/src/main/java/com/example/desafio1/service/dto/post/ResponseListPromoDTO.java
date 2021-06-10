package com.example.desafio1.service.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListPromoDTO {

    private int userId;
    private ArrayList<ResponsePromoPostDTO> posts = new ArrayList<>();

}
