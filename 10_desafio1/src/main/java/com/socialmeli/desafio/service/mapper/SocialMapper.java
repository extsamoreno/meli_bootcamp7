package com.socialmeli.desafio.service.mapper;

import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PostModel;
import com.socialmeli.desafio.model.UserModel;
import com.socialmeli.desafio.model.SellerModel;
import com.socialmeli.desafio.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class SocialMapper {

    @Autowired
    ISocialService iSocialService;   //borrar despues de la prueba??


    public static FollowersCountDTO toFollowerCountDTO (SellerModel vendedor){  //Conviente vendedor a vendedorDTO(FollowersCountDTO)
        return new FollowersCountDTO(vendedor.getUserId(), vendedor.getUserName(), vendedor.getFollowers().size());
    }




    public static FollowersListDTO toFollowersListDto (SellerModel vendedor, ArrayList<UserDTO> followers){

        //FollowersListDTO, incluye  el nombre, el id del vendedor y la lista de seguidores
        FollowersListDTO followerList = new FollowersListDTO(vendedor.getUserId(), vendedor.getUserName(), followers);

        return followerList;  //no es una lista
    }

    public static UserDTO toUsuarioDTO (UserModel usuario){
        return new UserDTO(usuario.getUserId(), usuario.getUserName());
    }


    public static FollowedListDTO toFollowedListDto (UserModel usuario, ArrayList<SellerDTO> followed){ //usando en C0004

        //FollowersListDTO, incluye  el nombre, el id del vendedor y la lista de seguidos
        FollowedListDTO followedList = new FollowedListDTO(usuario.getUserId(), usuario.getUserName(), followed);

        return followedList;
    }

    public static SellerDTO toVendedorDTO (SellerModel vendedor){
        return new SellerDTO(vendedor.getUserId(), vendedor.getUserName());
    }



    //Recibe un publicacion y la convierte a su DTO
    public static PostDTO toPublicacionDTO (PostModel publicacion){
         PostDTO postDTO = new PostDTO();

         postDTO.setUserId(publicacion.getUserId());
         postDTO.setPostId(publicacion.getPostId());
         postDTO.setDate(publicacion.getDate());
         postDTO.setDetail(publicacion.getDetail());
         postDTO.setCategory(publicacion.getCategory());
         postDTO.setPrice(publicacion.getPrice());

        return postDTO;
    }


    public static PostOfFollowedSellerDTO toPublicacionesVendedoresSeguidosDTO (int userId, ArrayList<PostDTO> publicacionesDTO){
        PostOfFollowedSellerDTO postOfFollowedSellerDTO =new PostOfFollowedSellerDTO();

        postOfFollowedSellerDTO.setUserId(userId);
        postOfFollowedSellerDTO.setPosts(publicacionesDTO);

        return postOfFollowedSellerDTO;

    }


    //Recibe un publicacion y la convierte a su DTO
    public static PostPromoDTO toPromoDto (PostModel publicacion){
        PostPromoDTO postPromoDTO = new PostPromoDTO();

        postPromoDTO.setUserId(publicacion.getUserId());
        postPromoDTO.setPostId(publicacion.getPostId());
        postPromoDTO.setDate(publicacion.getDate());
        postPromoDTO.setDetail(publicacion.getDetail());
        postPromoDTO.setCategory(publicacion.getCategory());
        postPromoDTO.setPrice(publicacion.getPrice());
        postPromoDTO.setHasPromo(publicacion.isHasPromo());
        postPromoDTO.setDiscount(publicacion.getDiscount());

        return postPromoDTO;
    }



    public static CountPromoDTO countPromoDTO (SellerModel vendedor, int count){
        CountPromoDTO countPromoDTO= new CountPromoDTO();

        countPromoDTO.setUserId(vendedor.getUserId());
        countPromoDTO.setUserName(vendedor.getUserName());
        countPromoDTO.setPromoProductsCount(count);

        return countPromoDTO;
    }


    public static PromoListSellerDTO toPromoListVendedorDTO (SellerModel vendedor, ArrayList<PostPromoDTO> posts){
        PromoListSellerDTO promoListSellerDTO = new PromoListSellerDTO();

        promoListSellerDTO.setUserId(vendedor.getUserId());
        promoListSellerDTO.setUserName(vendedor.getUserName());
        promoListSellerDTO.setPosts(posts);

        return promoListSellerDTO;


    }


}
