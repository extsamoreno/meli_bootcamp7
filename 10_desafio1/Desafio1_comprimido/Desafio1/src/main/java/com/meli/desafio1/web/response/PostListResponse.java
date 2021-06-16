package com.meli.desafio1.web.response;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.dto.PromoPostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostListResponse {
    private int userId;
    private List<PostResponse> posts;
}
