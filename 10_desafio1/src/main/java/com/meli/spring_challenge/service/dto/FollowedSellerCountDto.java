package com.meli.spring_challenge.service.dto;

import com.meli.spring_challenge.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedSellerCountDto extends User {
    private int promoproducts_count;

}
