package com.meli.desafio1.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CusersResponse {
    private int userId;
    private String userName;
    private int followers_count;
}
