package com.spring.desafioSpring.DTOs;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountPromosDTO {
    private Integer userId;
    private String userName;
    private int promoproducts_count;
}
