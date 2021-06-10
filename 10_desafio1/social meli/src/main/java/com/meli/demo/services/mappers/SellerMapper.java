package com.meli.demo.services.mappers;

import com.meli.demo.dtos.PostDTO;
import com.meli.demo.dtos.SellerDTO;
import com.meli.demo.dtos.UserDTO;
import com.meli.demo.models.Post;
import com.meli.demo.models.Seller;

import java.util.ArrayList;

public class SellerMapper {

    public static SellerDTO toDTO(Seller seller){

        return new SellerDTO(seller.getId(),
                seller.getNombre(),
                seller.getPublicacions(),
                seller.getUsuarios());
    }


    public static Seller toSeller(SellerDTO seller){

        return new Seller(seller.getId(),
                seller.getNombre(),
                seller.getPublicacions(),
                seller.getUsuarios());
    }


}
