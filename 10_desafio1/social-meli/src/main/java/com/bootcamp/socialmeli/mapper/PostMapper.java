package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.DTO.request.PostPromoDTOreq;
import com.bootcamp.socialmeli.DTO.response.ListOfPostsDTOres;
import com.bootcamp.socialmeli.DTO.response.ListOfPostsWithUsernameDTOres;
import com.bootcamp.socialmeli.DTO.response.PostDTOres;
import com.bootcamp.socialmeli.DTO.request.PostDTOreq;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
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
                postDTOreq.getPrice(),
                false,
                0
        );
    }

    public Post toPost(PostPromoDTOreq postPromo) {
        return new Post(
                postPromo.getUserId(),
                postPromo.getPostId(),
                postPromo.getDate(),
                productMapper.toProdcut(postPromo.getDetail()),
                postPromo.getCategory(),
                postPromo.getPrice(),
                postPromo.isHasPromo(),
                postPromo.getDiscount()
        );
    }


    public ListOfPostsDTOres toListOfPostDTO(List<Post> postList, Integer userId) {
        ListOfPostsDTOres listFollowedPost = new ListOfPostsDTOres();
        listFollowedPost.setUserId(userId);

        List<PostDTOres> listPost = postList.stream()
                .map(p -> toPostDTO(p))
                .collect(Collectors.toList());

        listFollowedPost.setPosts(listPost);

        return listFollowedPost;
    }

    public ListOfPostsWithUsernameDTOres toListOfPostWithUsernameDTO(List<Post> postList, User user) {
        ListOfPostsWithUsernameDTOres listFollowedPost = new ListOfPostsWithUsernameDTOres();
        listFollowedPost.setUserId(user.getUserId());
        listFollowedPost.setUsername(user.getUserName());

        List<PostDTOres> listPost = postList.stream()
                .map(p -> toPostDTO(p))
                .collect(Collectors.toList());

        listFollowedPost.setPosts(listPost);

        return listFollowedPost;
    }

    public PostDTOres toPostDTO(Post post) {

        return new PostDTOres(
                post.getPostId(),
                post.getDate(),
                productMapper.toProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

}
