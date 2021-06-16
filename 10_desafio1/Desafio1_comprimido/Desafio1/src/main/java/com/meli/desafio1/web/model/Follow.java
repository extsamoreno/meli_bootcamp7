package com.meli.desafio1.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private int userId;
    private List<Integer> follows_id;
}
