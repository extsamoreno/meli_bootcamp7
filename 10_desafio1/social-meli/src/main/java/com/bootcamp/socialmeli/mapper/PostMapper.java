package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.DTO.response.ListOfFollowedPostsDTOres;
import com.bootcamp.socialmeli.DTO.response.FollowedPostDTOres;
import com.bootcamp.socialmeli.DTO.request.PostDTOreq;
import com.bootcamp.socialmeli.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    @Autowired
    ProductMapper productMapper;

    public Post toPost(PostDTOreq postDTOreq) {
        return new Post(
                postDTOreq.getUserId(),
                postDTOreq.getPostId(),
                postDTOreq.getDate(),
                productMapper.toProdcut(postDTOreq.getDetail()),
                postDTOreq.getCategory(),
                postDTOreq.getPrice()
        );
    }

    public ListOfFollowedPostsDTOres toListOfFollowedPostDTO(List<Post> postFollowed, Integer userId) {
        ListOfFollowedPostsDTOres listFollowedPost = new ListOfFollowedPostsDTOres();
        listFollowedPost.setUserId(userId);

        List<FollowedPostDTOres> listPost = postFollowed.stream()
                .map(p -> toFollowedPostDTO(p))
                .collect(Collectors.toList());

        listFollowedPost.setPosts(listPost);

        return listFollowedPost;
    }

    FollowedPostDTOres toFollowedPostDTO(Post post) {

        return new FollowedPostDTOres(
                post.getPostId(),
                post.getDate(),
                productMapper.toProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice()
        );
    }
}
