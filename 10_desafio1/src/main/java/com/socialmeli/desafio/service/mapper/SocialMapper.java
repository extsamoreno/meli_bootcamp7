package com.socialmeli.desafio.service.mapper;

import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;

import java.util.ArrayList;

public class SocialMapper {


    public static FollowersCountDTO toFollowerCountDTO (VendedorModel vendedor){  //Conviente vendedor a vendedorDTO(FollowersCountDTO)
        return new FollowersCountDTO(vendedor.getUserId(), vendedor.getUserName(), vendedor.getFollowers().size());
    }

    public static FollowersListDTO toFollowersListDto (VendedorModel vendedor){
        ArrayList<UsuarioDTO> followers = new ArrayList<>();  //creo una nueva lista con los usuarios de ese vendedor, con objetos dto

        for (int i = 0; i < vendedor.getFollowers().size(); i++) {

            UsuarioDTO userDto= SocialMapper.toUsuarioDTO(vendedor.getFollowers().get(i));
            followers.add(userDto);
        }

        //FollowersListDTO, incluye  el nombre, el id del vendedor y la lista de seguidores
        FollowersListDTO followerList = new FollowersListDTO(vendedor.getUserId(), vendedor.getUserName(), followers);


        return followerList;
    }

    public static UsuarioDTO toUsuarioDTO (UsuarioModel usuario){
        return new UsuarioDTO(usuario.getUserId(), usuario.getUserName());
    }


    public static FollowedListDTO toFollowedListDto (UsuarioModel usuario){
        ArrayList<VendedorDTO> followed = new ArrayList<>();

        for (int i = 0; i < usuario.getFollows().size(); i++) {


            VendedorDTO vendedorDto= SocialMapper.toVendedorDTO(usuario.getFollows().get(i));
            followed.add(vendedorDto);
        }

        //FollowersListDTO, incluye  el nombre, el id del vendedor y la lista de seguidores
        FollowedListDTO followedList = new FollowedListDTO(usuario.getUserId(), usuario.getUserName(), followed);


        return followedList;
    }

    public static VendedorDTO toVendedorDTO (VendedorModel vendedor){
        return new VendedorDTO(vendedor.getUserId(), vendedor.getUserName());
    }



}
