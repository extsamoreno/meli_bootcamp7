package com.example.demo.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {
    private String name;
    private int id;
    private int followers_count;
}
