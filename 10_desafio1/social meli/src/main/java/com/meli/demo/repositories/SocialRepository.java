package com.meli.demo.repositories;


import com.meli.demo.dtos.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository {
    boolean Follow(int iduser, int id_vendedor);
    void cargarDatos();
    CountUsersDTO countUsers(int iduser);
    LisUsersResponseDTO listUsers(int iduser);
    ListSellersResponseDTO listVendedores(int iduser);
    boolean newPost(PostDTO publi);
    ListSellersPostDTO getListPostVendedors(int iduser);
    boolean unFollow(int iduser, int id_vendedor);
    boolean newPostDiscount(PostDiscountDTO publi);
    SellerDTO getVendedor(int userId);

}
