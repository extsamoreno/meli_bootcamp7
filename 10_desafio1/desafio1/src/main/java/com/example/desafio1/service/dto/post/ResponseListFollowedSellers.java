package com.example.desafio1.service.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListFollowedSellers {

    private ArrayList<ResponseListPostDTO> listFollowersPosts = new ArrayList<>();
}
