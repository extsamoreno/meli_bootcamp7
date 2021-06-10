package com.meli.demo.services.mappers;

import com.meli.demo.dtos.ListSellersPostDTO;
import com.meli.demo.dtos.ListSellersResponseDTO;
import com.meli.demo.models.ListSeller;
import com.meli.demo.models.ListSellerPost;

public class ListSellerPostMapper {

    public static ListSellersPostDTO toDTO(ListSellerPost list_post){

        return new ListSellersPostDTO(list_post.getUserId(),
                list_post.getPosts());
    }

    public static ListSellerPost toList(ListSellersPostDTO list_post){

        return new ListSellerPost(list_post.getUserId(),
                list_post.getPosts());
    }


}
