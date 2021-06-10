package com.socialmeli.desafio.service;

import com.socialmeli.desafio.Exception.SeguidorNoRegistradoException;
import com.socialmeli.desafio.Exception.SeguidorYaRegistradoException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import com.socialmeli.desafio.service.mapper.SocialMapper;
import com.socialmeli.desafio.socialRepository.IUserRepository;
import com.socialmeli.desafio.socialRepository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collections;


@Service
public class SocialService implements ISocialService {

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IVendedorRepository iVendedorRepository;


    public void follow(int idUsuario, int idVendedor) throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorYaRegistradoException {

        UsuarioModel usuario = iUserRepository.getUsuarioById(idUsuario);
        VendedorModel vendedor = iVendedorRepository.getVendedorById(idVendedor);

        if (usuario == null) {
            throw new UserIdNotFoundException(idUsuario);
        }
        if (vendedor == null) {
            throw new VendedorIdNotFoundException(idVendedor);
        }

        if (usuario.getFollows().contains(vendedor)){
            throw new SeguidorYaRegistradoException(idUsuario);

        }

        usuario.addFollow(vendedor);
        vendedor.addFollower(usuario);

    }

    public void unfollow(int idUsuario, int idVendedor) throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorNoRegistradoException {

        UsuarioModel usuario = iUserRepository.getUsuarioById(idUsuario);
        VendedorModel vendedor = iVendedorRepository.getVendedorById(idVendedor);

        if (usuario == null) {
            throw new UserIdNotFoundException(idUsuario);
        }
        if (vendedor == null) {
            throw new VendedorIdNotFoundException(idVendedor);
        }

        if (!usuario.getFollows().contains(vendedor)) {
            throw new SeguidorNoRegistradoException(idUsuario, idVendedor);

        }
        usuario.quitarFollow(vendedor);
        vendedor.removeFollower(usuario);
    }

    public FollowersCountDTO getCountFollowers(int id) throws VendedorIdNotFoundException { //CU002
        VendedorModel vendedor = iVendedorRepository.getVendedorById(id);
        if (vendedor == null) {
            throw new VendedorIdNotFoundException(id);
        }
        return SocialMapper.toFollowerCountDTO(vendedor);
    }


    public FollowersListDTO getFollowersList(int id, String order) throws VendedorIdNotFoundException{  //CU0003
        VendedorModel vendedor = iVendedorRepository.getVendedorById(id);

        if (vendedor == null) {
            throw new VendedorIdNotFoundException(id);
        }

        ArrayList<UsuarioDTO> followers = new ArrayList<>();

        for (int i = 0; i < vendedor.getFollowers().size(); i++) {
            UsuarioDTO userDto = SocialMapper.toUsuarioDTO(vendedor.getFollowers().get(i));
            followers.add(userDto);
        }

        if (order.equals("name_asc")) {
            sortUsuariosAscendentes(followers);

        } else if (order.equals("name_desc")) {
            sortUsuariosDescendentes(followers);
        }

        FollowersListDTO followerList = SocialMapper.toFollowersListDto(vendedor, followers);


        return followerList;  //No es una lista
    }


    public void createPost(PublicacionModel publicacion)throws VendedorIdNotFoundException {
        VendedorModel vendedor = iVendedorRepository.getVendedorById(publicacion.getUserId());
        if (vendedor == null) {
            throw new VendedorIdNotFoundException(publicacion.getUserId());
        }
        vendedor.addPost(publicacion);
    }


    //Devuelve lista de publicaciones seguidos por un usuario en las ultimas 2 semanas
    public PublicacionesVendedoresSeguidosDTO publicacionesVendedoresSeguidosDosSemanas(int id, String order) throws UserIdNotFoundException{
        UsuarioModel usuario = iUserRepository.getUsuarioById(id);
        if (usuario == null) {
            throw new UserIdNotFoundException(id);
        }
        ArrayList<VendedorModel> vendedores = getFollowedList(usuario);
        ArrayList<PublicacionModel> publicacionesUltimasDosSemanas;
        ArrayList<PublicacionModel> publicacionesDelVendedor = new ArrayList<>();
        ArrayList<PublicacionDTO> publicacionesDTO = new ArrayList<>();


        for (int v = 0; v < vendedores.size(); v++) {
            publicacionesUltimasDosSemanas = getPublicacionesVendedorDosSemanas(vendedores.get(v));
            publicacionesDelVendedor.addAll(publicacionesUltimasDosSemanas);
        }
        for (int p = 0; p < publicacionesDelVendedor.size(); p++) {
            PublicacionDTO publicacionDTO = SocialMapper.toPublicacionDTO(publicacionesDelVendedor.get(p));
            publicacionesDTO.add(publicacionDTO);
        }
        if (order.equals("date_asc")) {
            sortPublicacionesAscendente(publicacionesDTO);

        } else if (order.equals("date_desc")) {
            sortPublicacionesDescendente(publicacionesDTO);
        }
        return SocialMapper.toPublicacionesVendedoresSeguidosDTO(id, publicacionesDTO);
    }

    //Devuelve lista de vendedores seguidos por un usuario
    //Sobrecargado
    public FollowedListDTO getFollowedList(int id, String order)throws UserIdNotFoundException {
        UsuarioModel usuario = iUserRepository.getUsuarioById(id);
        if (usuario == null) {
            throw new UserIdNotFoundException(id);
        }
        ArrayList<VendedorDTO> followed = new ArrayList<>();


        for (int i = 0; i < usuario.getFollows().size(); i++) {
            VendedorModel vendedor = usuario.getFollows().get(i);

            VendedorDTO vendedorDTO = SocialMapper.toVendedorDTO(vendedor);
            followed.add(vendedorDTO);
        }
        if (order.equals("name_asc")) {
            sortVendedoresAscendentes(followed);

        } else if (order.equals("name_desc")) {
            sortVendedoresDescendentes(followed);
        }
        FollowedListDTO followedList = SocialMapper.toFollowedListDto(usuario, followed);

        return followedList;
    }


    public ArrayList<VendedorModel> getFollowedList(UsuarioModel usuario) {   //CU006
        ArrayList<VendedorModel> followed = new ArrayList<>();

        for (int i = 0; i < usuario.getFollows().size(); i++) {
            VendedorModel vendedor = usuario.getFollows().get(i);
            followed.add(vendedor);
        }
        return followed;
    }

    //Me devuelve lista de publicaciones de un vendedor en las ultimas 2 semanas
    public ArrayList<PublicacionModel> getPublicacionesVendedorDosSemanas(VendedorModel vendedor) {
        ArrayList<PublicacionModel> publicaciones = new ArrayList<>();

        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.WEEK_OF_YEAR, -2);
        Date dosSemanasAntes = calendario.getTime();

        for (int i = 0; i < vendedor.getPosts().size(); i++) {
            PublicacionModel publicacion = vendedor.getPosts().get(i);

            if (publicacion.getDate().compareTo(dosSemanasAntes) > 0) {
                publicaciones.add(publicacion);
            }
        }
        return publicaciones;
    }


    public void sortUsuariosAscendentes(ArrayList<UsuarioDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<UsuarioDTO>() {
            @Override
            public int compare(UsuarioDTO o1, UsuarioDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }


    public void sortUsuariosDescendentes(ArrayList<UsuarioDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<UsuarioDTO>() {
            @Override
            public int compare(UsuarioDTO o2, UsuarioDTO o1) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }


    public void sortVendedoresAscendentes(ArrayList<VendedorDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<VendedorDTO>() {
            @Override
            public int compare(VendedorDTO o1, VendedorDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }


    public void sortVendedoresDescendentes(ArrayList<VendedorDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<VendedorDTO>() {
            @Override
            public int compare(VendedorDTO o2, VendedorDTO o1) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }

    public void sortPublicacionesAscendente(ArrayList<PublicacionDTO> aSortear){

        Collections.sort(aSortear, new Comparator<PublicacionDTO>() {
            @Override
            public int compare(PublicacionDTO o2, PublicacionDTO o1) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
    }

    public void sortPublicacionesDescendente(ArrayList<PublicacionDTO> aSortear){

        Collections.sort(aSortear, new Comparator<PublicacionDTO>() {
            @Override
            public int compare(PublicacionDTO o2, PublicacionDTO o1) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

    }


}
