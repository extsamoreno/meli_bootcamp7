package com.meli.demo.services.mappers;

import com.meli.demo.dtos.ListSellersResponseDTO;
import com.meli.demo.dtos.PostDTO;
import com.meli.demo.models.ListSeller;
import com.meli.demo.models.Post;

public class ListSellerMapper {

    public static ListSellersResponseDTO toDTO(ListSeller list){

        return new ListSellersResponseDTO(list.getUserId(),
                list.getUserName(),
                list.getFollowed());
    }

    public static ListSeller toListSeller(ListSellersResponseDTO list){

        return new ListSeller(list.getUserId(),
                list.getUserName(),
                list.getFollowed());
    }
}
