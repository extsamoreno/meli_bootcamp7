package com.springChallenge.api.service.contract;

import com.springChallenge.api.controller.dto.product.PostDTO;

public interface IProductService {
    void createNewPost(PostDTO postDTO);
}
