package com.socialmeli.desafio.service.mapper;

import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;

public class SocialMapper {


    public static FollowersCountDTO toFollowerCountDTO (VendedorModel vendedor){  //Conviente vendedor a vendedorDTO(FollowersCountDTO)
        return new FollowersCountDTO(vendedor.getUserId(), vendedor.getUserName(), vendedor.getFollowers().size());
    }
}
