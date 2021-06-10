package com.meli.demo.repositories;


import com.meli.demo.dtos.*;
import com.meli.demo.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository {
    boolean Follow(int iduser, int id_vendedor);
    void cargarDatos();
    CountUser countUsers(int iduser);
    Seller listUsers(int iduser);
    ListSeller listVendedores(int iduser);
    boolean newPost(Post publi);
    ListSellerPost getListPostVendedors(int iduser);
    boolean unFollow(int iduser, int id_vendedor);
    boolean newPostDiscount(Post publi);
    Seller getVendedor(int userId);
    User getUser(int userId);

}
