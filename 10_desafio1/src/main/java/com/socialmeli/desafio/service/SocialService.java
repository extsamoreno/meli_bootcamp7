package com.socialmeli.desafio.service;


import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import com.socialmeli.desafio.service.mapper.SocialMapper;
import com.socialmeli.desafio.socialRepository.IUsuarioRepository;
import com.socialmeli.desafio.socialRepository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collections;


@Service
public class SocialService implements ISocialService{

    @Autowired
    IUsuarioRepository iUsuarioRepository;
    @Autowired
    IVendedorRepository iVendedorRepository;


    public void follow(int idUsuario, int idVendedor){

        UsuarioModel usuario= iUsuarioRepository.getUsuarioById(idUsuario);
        VendedorModel vendedor= iVendedorRepository.getVendedorById(idVendedor);

        usuario.agregarFollow(vendedor);
        vendedor.agregarFollower(usuario);

    }

    public void unfollow(int idUsuario, int idVendedor){

        UsuarioModel usuario= iUsuarioRepository.getUsuarioById(idUsuario);
        VendedorModel vendedor= iVendedorRepository.getVendedorById(idVendedor);

        usuario.quitarFollow(vendedor);
        vendedor.quitarFollower(usuario);

        //falta verificar excepciones
    }

    public FollowersCountDTO getCountFollowers(int id){
        VendedorModel vendedor = iVendedorRepository.getVendedorById(id);
        return SocialMapper.toFollowerCountDTO(vendedor);
    }


    public FollowersListDTO getFollowersList(int id){
        VendedorModel vendedor = iVendedorRepository.getVendedorById(id);
        return SocialMapper.toFollowersListDto(vendedor);
    }


    public FollowedListDTO getFollowedList(int id){
        UsuarioModel usuario = iUsuarioRepository.getUsuarioById(id);
        return SocialMapper.toFollowedListDto(usuario);
    }

    public void createPost(PublicacionModel publicacion){
       VendedorModel vendedor= iVendedorRepository.getVendedorById(publicacion.getUserId());
        System.out.println(publicacion.getUserId());
       vendedor.addPost(publicacion);
    }


    //Devuelve lista de publicaciones seguidos por un usuario en las ultimas 2 semanas
    public PublicacionesVendedoresSeguidosDTO publicacionesVendedoresSeguidosDosSemanas (int id){
        UsuarioModel usuario = iUsuarioRepository.getUsuarioById(id);
        ArrayList<VendedorModel> vendedores = getFollowedList(usuario);
        ArrayList<PublicacionModel> publicacionesUltimasDosSemanas;
        ArrayList<PublicacionModel> publicacionesDelVendedor= new ArrayList<>();
        ArrayList<PublicacionDTO> publicacionesDTO= new ArrayList<>();


        for (int v = 0; v < vendedores.size(); v++) {
            publicacionesUltimasDosSemanas = getPublicacionesVendedorDosSemanas(vendedores.get(v));
            publicacionesDelVendedor.addAll(publicacionesUltimasDosSemanas);
        }
        for (int p = 0; p < publicacionesDelVendedor.size(); p++) {
            PublicacionDTO publicacionDTO= SocialMapper.toPublicacionDTO(publicacionesDelVendedor.get(p));
            publicacionesDTO.add(publicacionDTO);
        }

        return SocialMapper.toPublicacionesVendedoresSeguidosDTO(id,publicacionesDTO);
    }

    //Devuelve lista de vendedores seguidos por un usuario
    public ArrayList<VendedorModel> getFollowedList(UsuarioModel usuario){
        ArrayList<VendedorModel> followed = new ArrayList<>();

        for (int i = 0; i < usuario.getFollows().size(); i++) {
            VendedorModel vendedor= usuario.getFollows().get(i);
            followed.add(vendedor);
        }
      return followed;
    }


    //Me devuelve lista de publicaciones de un vendedor en las ultimas 2 semanas
    public ArrayList<PublicacionModel> getPublicacionesVendedorDosSemanas(VendedorModel vendedor){
        ArrayList<PublicacionModel> publicaciones = new ArrayList<>();

        Calendar calendario= Calendar.getInstance();
        calendario.add(Calendar.WEEK_OF_YEAR,-2);
        Date dosSemanasAntes=calendario.getTime();

        for (int i = 0; i < vendedor.getPosts().size(); i++) {
            PublicacionModel publicacion =vendedor.getPosts().get(i);

            if (publicacion.getDate().compareTo(dosSemanasAntes)>0){
                publicaciones.add(publicacion);
           }
        }
        return publicaciones;
    }


    public void sortUsuariosAscendentes (ArrayList <FollowersListDTO> aSortear){


        Collections.sort(aSortear, new Comparator<FollowersListDTO>() {
            @Override
            public int compare(FollowersListDTO o1, FollowersListDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }




}
