package com.meli.socialmeli.model.dto;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSellerListPromoDTO {
    private int userId;
    private String userName;
    private ArrayList<PostPromoDTO> post = new ArrayList<>();
}
