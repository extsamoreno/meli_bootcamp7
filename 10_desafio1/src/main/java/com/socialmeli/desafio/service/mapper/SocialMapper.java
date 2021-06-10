package com.socialmeli.desafio.service.mapper;

import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import com.socialmeli.desafio.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class SocialMapper {

    @Autowired
    ISocialService iSocialService;   //borrar despues de la prueba??


    public static FollowersCountDTO toFollowerCountDTO (VendedorModel vendedor){  //Conviente vendedor a vendedorDTO(FollowersCountDTO)
        return new FollowersCountDTO(vendedor.getUserId(), vendedor.getUserName(), vendedor.getFollowers().size());
    }




    public static FollowersListDTO toFollowersListDto (VendedorModel vendedor, ArrayList<UsuarioDTO> followers){

        //FollowersListDTO, incluye  el nombre, el id del vendedor y la lista de seguidores
        FollowersListDTO followerList = new FollowersListDTO(vendedor.getUserId(), vendedor.getUserName(), followers);

        return followerList;  //no es una lista
    }

    public static UsuarioDTO toUsuarioDTO (UsuarioModel usuario){
        return new UsuarioDTO(usuario.getUserId(), usuario.getUserName());
    }


    public static FollowedListDTO toFollowedListDto (UsuarioModel usuario,ArrayList<VendedorDTO> followed){ //usando en C0004

        //FollowersListDTO, incluye  el nombre, el id del vendedor y la lista de seguidos
        FollowedListDTO followedList = new FollowedListDTO(usuario.getUserId(), usuario.getUserName(), followed);

        return followedList;
    }

    public static VendedorDTO toVendedorDTO (VendedorModel vendedor){
        return new VendedorDTO(vendedor.getUserId(), vendedor.getUserName());
    }



    //Recibe un publicacion y la convierte a su DTO
    public static PublicacionDTO toPublicacionDTO (PublicacionModel publicacion){
         PublicacionDTO publicacionDTO = new PublicacionDTO();

         publicacionDTO.setUserId(publicacion.getUserId());
         publicacionDTO.setId_post(publicacion.getPostId());
         publicacionDTO.setDate(publicacion.getDate());
         publicacionDTO.setDetail(publicacion.getDetail());
         publicacionDTO.setCategory(publicacion.getCategory());
         publicacionDTO.setPrice(publicacion.getPrice());

        return publicacionDTO;
    }


    public static PublicacionesVendedoresSeguidosDTO toPublicacionesVendedoresSeguidosDTO (int userId, ArrayList<PublicacionDTO> publicacionesDTO){
        PublicacionesVendedoresSeguidosDTO publicacionesVendedoresSeguidosDTO =new PublicacionesVendedoresSeguidosDTO();

        publicacionesVendedoresSeguidosDTO.setUserId(userId);
        publicacionesVendedoresSeguidosDTO.setPublicaciones(publicacionesDTO);

        return publicacionesVendedoresSeguidosDTO;

    }


    //Recibe un publicacion y la convierte a su DTO
    public static PostPromoDTO toPromoDto (PublicacionModel publicacion){
        PostPromoDTO postPromoDTO = new PostPromoDTO();

        postPromoDTO.setUserId(publicacion.getUserId());
        postPromoDTO.setId_post(publicacion.getPostId());
        postPromoDTO.setDate(publicacion.getDate());
        postPromoDTO.setDetail(publicacion.getDetail());
        postPromoDTO.setCategory(publicacion.getCategory());
        postPromoDTO.setPrice(publicacion.getPrice());
        postPromoDTO.setHasPromo(publicacion.isHasPromo());
        postPromoDTO.setDiscount(publicacion.getDiscount());

        return postPromoDTO;
    }



    public static CountPromoDTO countPromoDTO (VendedorModel vendedor,int count){
        CountPromoDTO countPromoDTO= new CountPromoDTO();

        countPromoDTO.setUserId(vendedor.getUserId());
        countPromoDTO.setUserName(vendedor.getUserName());
        countPromoDTO.setPromoProductsCount(count);

        return countPromoDTO;
    }


    public static PromoListVendedorDTO toPromoListVendedorDTO (VendedorModel vendedor,ArrayList<PostPromoDTO> posts){
        PromoListVendedorDTO promoListVendedorDTO = new PromoListVendedorDTO();

        promoListVendedorDTO.setUserId(vendedor.getUserId());
        promoListVendedorDTO.setUserName(vendedor.getUserName());
        promoListVendedorDTO.setPosts(posts);

        return promoListVendedorDTO;


    }


}
