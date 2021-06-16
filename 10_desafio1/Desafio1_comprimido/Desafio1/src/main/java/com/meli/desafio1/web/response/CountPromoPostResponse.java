package com.meli.desafio1.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountPromoPostResponse {
    private int userId;
    private String userName;
    private int promoproducts_count;
}
