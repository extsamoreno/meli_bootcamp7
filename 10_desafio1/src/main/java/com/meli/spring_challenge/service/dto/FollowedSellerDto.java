package com.meli.spring_challenge.service.dto;

import com.meli.spring_challenge.model.Post;
import com.meli.spring_challenge.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedSellerDto extends User {
    private List<Post> posts;
}
