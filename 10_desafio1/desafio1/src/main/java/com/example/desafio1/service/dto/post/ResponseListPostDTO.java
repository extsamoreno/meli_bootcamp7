package com.example.desafio1.service.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListPostDTO {

    private int userId;
    private ArrayList<ResponsePostDTO> posts = new ArrayList<>();
}
