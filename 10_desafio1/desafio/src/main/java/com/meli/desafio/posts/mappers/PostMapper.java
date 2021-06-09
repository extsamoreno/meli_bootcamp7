package com.meli.desafio.posts.mappers;

import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.PostDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PostMapper {

    public static Post DtoToPost(PostDTO postDTO){
        Post post = new Post();
        post.setUserId(postDTO.getUserId());
        post.setPostId(postDTO.getPostId());
        post.setDetail(postDTO.getDetail());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());

        Integer day = Integer.parseInt(postDTO.getDate().substring(0, 2));
        Integer month = Integer.parseInt(postDTO.getDate().substring(3, 5));
        Integer year = Integer.parseInt(postDTO.getDate().substring(6, 10));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        post.setDate(calendar.getTime());

        return post;
    }

    public static PostDTO postToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(post.getUserId());
        postDTO.setPostId(post.getPostId());
        postDTO.setDetail(post.getDetail());
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        postDTO.setDate(dateFormat.format(post.getDate()));

        return postDTO;
    }

    public static List<PostDTO> postToDTOList(List<Post> list) {
        List<PostDTO> listDTO = new ArrayList<>();

        for (Post p : list){
            listDTO.add(postToDto(p));
        }

        return listDTO;
    }
}
