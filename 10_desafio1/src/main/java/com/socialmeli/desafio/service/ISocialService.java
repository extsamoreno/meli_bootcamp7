package com.socialmeli.desafio.service;

import com.socialmeli.desafio.dto.FollowedListDTO;
import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.dto.FollowersListDTO;
import com.socialmeli.desafio.dto.PublicacionesVendedoresSeguidosDTO;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;

import java.util.ArrayList;

public interface ISocialService {

    public void follow(int idUsuario, int idVendedor);
    public FollowersCountDTO getCountFollowers(int id);
    public FollowersListDTO getFollowersList(int id);
    public FollowedListDTO getFollowedList(int id);
    public void createPost(PublicacionModel publicacion);
    public void unfollow(int idUsuario, int idVendedor);
    public PublicacionesVendedoresSeguidosDTO publicacionesVendedoresSeguidosDosSemanas (int id);
    public ArrayList<VendedorModel> getFollowedList(UsuarioModel usuario);
    public ArrayList<PublicacionModel> getPublicacionesVendedorDosSemanas(VendedorModel vendedor);
}
