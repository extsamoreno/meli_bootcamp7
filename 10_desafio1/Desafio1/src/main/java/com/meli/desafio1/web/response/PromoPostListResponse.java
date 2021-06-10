package com.meli.desafio1.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostListResponse {
    private int userId;
    private String userName;
    private List<PostResponse> posts;
}
