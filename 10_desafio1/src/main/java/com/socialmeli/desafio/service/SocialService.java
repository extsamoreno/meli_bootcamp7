package com.socialmeli.desafio.service;


import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import com.socialmeli.desafio.service.mapper.SocialMapper;
import com.socialmeli.desafio.socialRepository.IUsuarioRepository;
import com.socialmeli.desafio.socialRepository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialService implements ISocialService{

    @Autowired
    IUsuarioRepository iUsuarioRepository;
    @Autowired
    IVendedorRepository iVendedorRepository;


    public void follow(int idUsuario, int idVendedor){

        UsuarioModel usuario= iUsuarioRepository.getUsuarioById(idUsuario);
        System.out.println("usuario = " + usuario);
        VendedorModel vendedor= iVendedorRepository.getVendedorById(idVendedor);
        System.out.println("vendedor = " + vendedor);

        //System.out.println("entra al follow");
        usuario.agregarFollow(vendedor);
        //System.out.println("vendedor " + vendedor);
        vendedor.agregarFollower(usuario);


        //falta verificar excepciones

    }

    public FollowersCountDTO getCountFollowers(int id){
        VendedorModel vendedor = iVendedorRepository.getVendedorById(id);
        //falta verificar excepciones


        return SocialMapper.toFollowerCountDTO(vendedor);
    }







}
