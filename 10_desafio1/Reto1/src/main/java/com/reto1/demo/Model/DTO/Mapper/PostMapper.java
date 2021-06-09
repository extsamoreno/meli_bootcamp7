package com.reto1.demo.Model.DTO.Mapper;

import com.reto1.demo.Model.DTO.LastPostDTO;
import com.reto1.demo.Model.DTO.PostDTO;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {


    public static LastPostDTO toLastPostDTO(User user, ArrayList<Post> recentPost) {
        List<PostDTO> recentPostDTO = recentPost.stream()
                .map(post -> toPostDTO(post))
                .collect(Collectors.toList());
        return new LastPostDTO(user.getId(), recentPostDTO);
    }

    public static PostDTO toPostDTO(Post post){
        return new PostDTO(post.getId_post(), post.getDate(), post.getDetail(),
                post.getCategory(), post.getPrice());
    }
}
