package com.springChallenge.api.service.implementation;

import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.service.contract.IProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class ProductService implements IProductService {
    @Override
    public void createNewPost(PostDTO postDTO) {
        validatePost(postDTO);
        //TODO:add saveToRepo
    }

    private void validatePost(PostDTO postDTO) {
        //TODO:add date comparator
        //if (postDTO.getDate().after())
    }
}
