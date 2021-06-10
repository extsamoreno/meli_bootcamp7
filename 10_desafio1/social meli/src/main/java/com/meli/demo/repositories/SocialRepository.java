package com.meli.demo.repositories;


import com.meli.demo.dtos.*;
import com.meli.demo.models.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository {
    boolean Follow(int iduser, int id_vendedor);
    void cargarDatos();
    CountUsersDTO countUsers(int iduser);
    LisUsersResponseDTO listUsers(int iduser);
    ListSellersResponseDTO listVendedores(int iduser);
    boolean newPost(Post publi);
    ListSellersPostDTO getListPostVendedors(int iduser);
    boolean unFollow(int iduser, int id_vendedor);
    boolean newPostDiscount(Post publi);
    SellerDTO getVendedor(int userId);

}
