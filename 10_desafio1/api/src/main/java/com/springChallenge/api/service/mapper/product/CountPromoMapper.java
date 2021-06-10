package com.springChallenge.api.service.mapper.product;

import com.springChallenge.api.controller.dto.product.CountPromoDTO;
import com.springChallenge.api.repository.entity.User;

public class CountPromoMapper {
    public static CountPromoDTO toCountPromoDTO(User user, Integer count){
        return new CountPromoDTO(user.getUserId(), user.getUserName(), count);
    }
}
