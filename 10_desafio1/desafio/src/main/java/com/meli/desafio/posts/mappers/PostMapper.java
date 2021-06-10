package com.meli.desafio.posts.mappers;

import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.PostDTO;
import com.meli.desafio.posts.models.dto.PostPromoDTO;
import com.meli.desafio.posts.models.dto.PostPromoListDTO;
import com.meli.desafio.posts.models.dto.PromoCountDTO;
import com.meli.desafio.users.models.User;
import com.meli.desafio.utils.ChallengeUtils;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {

    public static Post DtoToPost(PostDTO postDTO){
        return Post.builder()
                .userId(postDTO.getUserId())
                .postId(postDTO.getPostId())
                .detail(postDTO.getDetail())
                .category(postDTO.getCategory())
                .price(postDTO.getPrice())
                .hasPromo(false)
                .discount(0.00)
                .date(ChallengeUtils.stringToDate(postDTO.getDate()))
                .build();
    }
    public static List<PostDTO> postToDTOList(List<Post> list) {
        List<PostDTO> listDTO = new ArrayList<>();

        for (Post p : list){
                listDTO.add(postToPromoDto(p));
        }

        return listDTO;
    }

    public static PostPromoDTO postToPromoDto(Post post) {
        return PostPromoDTO.promoBuilder()
                .userId(post.getUserId())
                .postId(post.getPostId())
                .detail(post.getDetail())
                .category(post.getCategory())
                .price(post.getPrice())
                .hasPromo(post.isHasPromo())
                .discount(post.getDiscount())
                .date(ChallengeUtils.dateToString(post.getDate()))
                .build();
    }

    public static Post promoDTOToPost(PostPromoDTO postPromoDTO){
        return Post.builder()
                .userId(postPromoDTO.getUserId())
                .postId(postPromoDTO.getPostId())
                .detail(postPromoDTO.getDetail())
                .category(postPromoDTO.getCategory())
                .price(postPromoDTO.getPrice())
                .hasPromo(postPromoDTO.isHasPromo())
                .discount(postPromoDTO.getDiscount())
                .date(ChallengeUtils.stringToDate(postPromoDTO.getDate()))
                .build();

    }

    public static PromoCountDTO postToCountDTO(User user, int size) {
        return PromoCountDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .promoCount(size)
                .build();
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
