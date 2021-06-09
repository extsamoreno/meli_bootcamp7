package com.socialmeli.desafio.service;

import com.socialmeli.desafio.dto.FollowedListDTO;
import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.dto.FollowersListDTO;
import com.socialmeli.desafio.model.PublicacionModel;

public interface ISocialService {

    public void follow(int idUsuario, int idVendedor);
    public FollowersCountDTO getCountFollowers(int id);
    public FollowersListDTO getFollowersList(int id);
    public FollowedListDTO getFollowedList(int id);
    public void createPost(PublicacionModel publicacion);
}
