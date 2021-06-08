package com.socialmeli.desafio.service;

import com.socialmeli.desafio.dto.FollowersCountDTO;

public interface ISocialService {

    public void follow(int idUsuario, int idVendedor);
    public FollowersCountDTO getCountFollowers(int id);
}
