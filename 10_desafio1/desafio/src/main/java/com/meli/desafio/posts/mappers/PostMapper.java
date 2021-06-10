package com.meli.desafio.posts.mappers;

import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.PostDTO;
import com.meli.desafio.posts.models.dto.PostPromoDTO;
import com.meli.desafio.posts.models.dto.PostPromoListDTO;
import com.meli.desafio.posts.models.dto.PromoCountDTO;
import com.meli.desafio.users.models.User;
import com.meli.desafio.utils.ChallengeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PostMapper {

    public static Post DtoToPost(PostDTO postDTO){
        Post post = new Post();
        post.setUserId(postDTO.getUserId());
        post.setPostId(postDTO.getPostId());
        post.setDetail(postDTO.getDetail());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());
        post.setHasPromo(false);
        post.setDiscount(0.00);

        post.setDate(ChallengeUtils.stringToDate(postDTO.getDate()));

        return post;
    }

    public static PostDTO postToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(post.getUserId());
        postDTO.setPostId(post.getPostId());
        postDTO.setDetail(post.getDetail());
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());

        postDTO.setDate(ChallengeUtils.dateToString(post.getDate()));

        return postDTO;
    }

    public static List<PostDTO> postToDTOList(List<Post> list) {
        List<PostDTO> listDTO = new ArrayList<>();

        for (Post p : list){
            //if(p.isHasPromo()){
                listDTO.add(postToPromoDto(p));
            //}else {
            //    listDTO.add(postToDto(p));
            //}
        }

        return listDTO;
    }

    public static PostPromoDTO postToPromoDto(Post post) {
        PostPromoDTO postPromoDTO = new PostPromoDTO();
        postPromoDTO.setUserId(post.getUserId());
        postPromoDTO.setPostId(post.getPostId());
        postPromoDTO.setDetail(post.getDetail());
        postPromoDTO.setCategory(post.getCategory());
        postPromoDTO.setPrice(post.getPrice());
        postPromoDTO.setHasPromo(post.isHasPromo());
        postPromoDTO.setDiscount(post.getDiscount());
        postPromoDTO.setDate(ChallengeUtils.dateToString(post.getDate()));
        return postPromoDTO;
    }

    public static Post promoDTOToPost(PostPromoDTO postPromoDTO){
        Post post = new Post();
        post.setUserId(postPromoDTO.getUserId());
        post.setPostId(postPromoDTO.getPostId());
        post.setDetail(postPromoDTO.getDetail());
        post.setCategory(postPromoDTO.getCategory());
        post.setPrice(postPromoDTO.getPrice());
        post.setHasPromo(postPromoDTO.isHasPromo());
        post.setDiscount(postPromoDTO.getDiscount());
        post.setDate(ChallengeUtils.stringToDate(postPromoDTO.getDate()));
        return post;
    }

    public static PromoCountDTO postToCountDTO(User user, int size) {
        PromoCountDTO promoCountDTO = new PromoCountDTO();
        promoCountDTO.setUserId(user.getId());
        promoCountDTO.setUserName(user.getUserName());
        promoCountDTO.setPromoCount(size);

        return promoCountDTO;
    }

    public static PostPromoListDTO postListToPromoListDTO(User user, List<Post> list){
        List<PostPromoDTO> listDTOs = new ArrayList<>();
        for(Post p: list){
            listDTOs.add(postToPromoDto(p));
        }

        return PostPromoListDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .posts(listDTOs)
                .build();
    }
}
