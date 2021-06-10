package com.example.desafiospring.socialmeli.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PromoUserProductDTO {
    int userId;
    String userName;
    int promoproducts_count;
}

