package com.socialmeli.desafio.service;

import com.socialmeli.desafio.Exception.SeguidorNoRegistradoException;
import com.socialmeli.desafio.Exception.SeguidorYaRegistradoException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.VendedorModel;

import java.util.ArrayList;

public interface ISocialService {

    void follow(int idUsuario, int idVendedor) throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorYaRegistradoException;

    FollowersCountDTO getCountFollowers(int id) throws VendedorIdNotFoundException;

    FollowersListDTO getFollowersList(int id, String order) throws VendedorIdNotFoundException;

    void createPost(PublicacionModel publicacion) throws UserIdNotFoundException, VendedorIdNotFoundException;

    void unfollow(int idUsuario, int idVendedor) throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorNoRegistradoException;

    PublicacionesVendedoresSeguidosDTO publicacionesVendedoresSeguidosDosSemanas(int id, String order) throws UserIdNotFoundException;

    FollowedListDTO getFollowedList(int id, String order) throws UserIdNotFoundException;

    ArrayList<PublicacionModel> getPublicacionesVendedorDosSemanas(VendedorModel vendedor);

    void sortUsuariosAscendentes(ArrayList<UsuarioDTO> aSortear);

    void sortUsuariosDescendentes(ArrayList<UsuarioDTO> aSortear);

    void sortVendedoresAscendentes(ArrayList<VendedorDTO> aSortear);

    void sortVendedoresDescendentes(ArrayList<VendedorDTO> aSortear);


}
