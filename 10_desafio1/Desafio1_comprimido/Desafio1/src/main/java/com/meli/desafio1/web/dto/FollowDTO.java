package com.meli.desafio1.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowDTO {
    private int userId;
    private List<Integer> follows_id;

}
