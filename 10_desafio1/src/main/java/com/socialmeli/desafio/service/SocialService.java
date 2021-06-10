package com.socialmeli.desafio.service;

import com.socialmeli.desafio.Exception.FollowerNotRegisteredException;
import com.socialmeli.desafio.Exception.RegisteredFollowerException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.SellerIdNotFoundException;
import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PostModel;
import com.socialmeli.desafio.model.UserModel;
import com.socialmeli.desafio.model.SellerModel;
import com.socialmeli.desafio.service.mapper.SocialMapper;
import com.socialmeli.desafio.socialRepository.IUserRepository;
import com.socialmeli.desafio.socialRepository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collections;


@Service
public class SocialService implements ISocialService {

    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    ISellerRepository iSellerRepository;


    public void follow(int userId, int sellerId) throws UserIdNotFoundException, SellerIdNotFoundException, RegisteredFollowerException {

        UserModel user = iUserRepository.getUsuarioById(userId);
        SellerModel seller = iSellerRepository.getVendedorById(sellerId);

        if (user == null) {
            throw new UserIdNotFoundException(userId);
        }
        if (seller == null) {
            throw new SellerIdNotFoundException(sellerId);
        }

        if (user.getFollows().contains(seller)) {
            throw new RegisteredFollowerException(userId);
        }
        user.addFollow(seller);
        seller.addFollower(user);

    }

    public void unfollow(int userId, int sellerId) throws UserIdNotFoundException, SellerIdNotFoundException, FollowerNotRegisteredException {

        UserModel user = iUserRepository.getUsuarioById(userId);
        SellerModel seller = iSellerRepository.getVendedorById(sellerId);

        if (user == null) {
            throw new UserIdNotFoundException(userId);
        }
        if (seller == null) {
            throw new SellerIdNotFoundException(sellerId);
        }

        if (!user.getFollows().contains(seller)) {
            throw new FollowerNotRegisteredException(userId, sellerId);
        }
        user.removeFollow(seller);
        seller.removeFollower(user);
    }

    public FollowersCountDTO getCountFollowers(int id) throws SellerIdNotFoundException { //CU002
        SellerModel seller = iSellerRepository.getVendedorById(id);
        if (seller == null) {
            throw new SellerIdNotFoundException(id);
        }
        return SocialMapper.toFollowerCountDTO(seller);
    }


    public FollowersListDTO getFollowersList(int id, String order) throws SellerIdNotFoundException {  //CU0003
        SellerModel seller = iSellerRepository.getVendedorById(id);

        if (seller == null) {
            throw new SellerIdNotFoundException(id);
        }

        ArrayList<UserDTO> followers = new ArrayList<>();

        for (int i = 0; i < seller.getFollowers().size(); i++) {
            UserDTO userDto = SocialMapper.toUsuarioDTO(seller.getFollowers().get(i));
            followers.add(userDto);
        }

        if (order.equals("name_asc")) {
            sortUserAsc(followers);

        } else if (order.equals("name_desc")) {
            sortUserDesc(followers);
        }
        FollowersListDTO followerList = SocialMapper.toFollowersListDto(seller, followers);

        return followerList;  //No es una lista
    }


    public void createPost(PostModel post) throws SellerIdNotFoundException {
        SellerModel seller = iSellerRepository.getVendedorById(post.getUserId());
        if (seller == null) {
            throw new SellerIdNotFoundException(post.getUserId());
        }
        seller.addPost(post);
    }


    //Devuelve lista de publicaciones seguidos por un usuario en las ultimas 2 semanas
    //Devuelve un objeto que adelanto tiene una lista de publicaciones
    public PostOfFollowedSellerDTO postFollowedSellersTwoWeeks(int id, String order) throws UserIdNotFoundException {
        UserModel user = iUserRepository.getUsuarioById(id);
        if (user == null) {
            throw new UserIdNotFoundException(id);
        }
        ArrayList<SellerModel> sellers = getFollowedList(user);
        ArrayList<PostModel> postsTwoWeeks;
        ArrayList<PostModel> sellerPosts = new ArrayList<>();
        ArrayList<PostDTO> postsDTO = new ArrayList<>();

        for (int v = 0; v < sellers.size(); v++) {
            postsTwoWeeks = getPostSellerTwoWeeks(sellers.get(v));
            sellerPosts.addAll(postsTwoWeeks);
        }
        for (int p = 0; p < sellerPosts.size(); p++) {
            PostDTO postDTO = SocialMapper.toPublicacionDTO(sellerPosts.get(p));
            postsDTO.add(postDTO);
        }
        if (order.equals("date_asc")) {
            sortPublicacionesAscendente(postsDTO);

        } else if (order.equals("date_desc")) {
            sortPublicacionesDescendente(postsDTO);
        }
        return SocialMapper.toPublicacionesVendedoresSeguidosDTO(id, postsDTO);
    }

    //Devuelve lista de vendedores seguidos por un usuario
    //Sobrecargado
    public FollowedListDTO getFollowedList(int id, String order) throws UserIdNotFoundException {
        UserModel user = iUserRepository.getUsuarioById(id);

        if (user == null) {
            throw new UserIdNotFoundException(id);
        }
        ArrayList<SellerDTO> followed = new ArrayList<>();

        for (int i = 0; i < user.getFollows().size(); i++) {
            SellerModel vendedor = user.getFollows().get(i);

            SellerDTO sellerDTO = SocialMapper.toVendedorDTO(vendedor);
            followed.add(sellerDTO);
        }
        if (order.equals("name_asc")) {
            sortSellerAsc(followed);

        } else if (order.equals("name_desc")) {
            sortSellerDesc(followed);
        }
        FollowedListDTO followedList = SocialMapper.toFollowedListDto(user, followed);

        return followedList;
    }


    public ArrayList<SellerModel> getFollowedList(UserModel user) {   //CU006
        ArrayList<SellerModel> followed = new ArrayList<>();

        for (int i = 0; i < user.getFollows().size(); i++) {
            SellerModel seller = user.getFollows().get(i);
            followed.add(seller);
        }
        return followed;
    }

    //Me devuelve lista de publicaciones de un vendedor en las ultimas 2 semanas
    public ArrayList<PostModel> getPostSellerTwoWeeks(SellerModel seller) {
        ArrayList<PostModel> posts = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, -2);
        Date dosSemanasAntes = cal.getTime();

        for (int i = 0; i < seller.getPosts().size(); i++) {
            PostModel post = seller.getPosts().get(i);

            if (post.getDate().compareTo(dosSemanasAntes) > 0) {
                posts.add(post);
            }
        }
        return posts;
    }



    public CountPromoDTO countPromoBySeller(int sellerId) throws SellerIdNotFoundException {
        SellerModel seller = iSellerRepository.getVendedorById(sellerId);
        int count = 0;

        if (seller == null) {
            throw new SellerIdNotFoundException(sellerId);
        }

        for (int i = 0; i < seller.getPosts().size(); i++) {
            PostModel post = seller.getPosts().get(i);

            if (post.isHasPromo()) {
                count++;
            }
        }
        return SocialMapper.countPromoDTO(seller, count);
    }


    public PromoListSellerDTO listPromo(int sellerId, String order) throws SellerIdNotFoundException {  //CU0012
        ArrayList<PostPromoDTO> posts = new ArrayList<>();

        SellerModel seller = iSellerRepository.getVendedorById(sellerId);

        if (seller == null) {
            throw new SellerIdNotFoundException(sellerId);
        }

        for (int i = 0; i < seller.getPosts().size(); i++) {
            PostModel publicacion = seller.getPosts().get(i);

            if (publicacion.isHasPromo()) {
                posts.add(SocialMapper.toPromoDto(publicacion));
            }
        }

        if (order.equals("name_asc")) {
            sortPromoAsc(posts);

        } else if (order.equals("name_desc")) {
            sortPromoDesc(posts);
        }
        return SocialMapper.toPromoListVendedorDTO(seller, posts);
    }


    //______________________SORTERS_____________________

    public void sortUserAsc(ArrayList<UserDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }


    public void sortUserDesc(ArrayList<UserDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o2.getUserName().compareTo(o1.getUserName());
            }
        });
    }


    public void sortSellerAsc(ArrayList<SellerDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<SellerDTO>() {
            @Override
            public int compare(SellerDTO o1, SellerDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
    }


    public void sortSellerDesc(ArrayList<SellerDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<SellerDTO>() {
            @Override
            public int compare(SellerDTO o1, SellerDTO o2) {
                return o2.getUserName().compareTo(o1.getUserName());
            }
        });
    }

    public void sortPublicacionesAscendente(ArrayList<PostDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<PostDTO>() {
            @Override
            public int compare(PostDTO o2, PostDTO o1) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
    }

    public void sortPublicacionesDescendente(ArrayList<PostDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<PostDTO>() {
            @Override
            public int compare(PostDTO o2, PostDTO o1) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }


    public void sortPromoAsc(ArrayList<PostPromoDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<PostPromoDTO>() {
            @Override
            public int compare(PostPromoDTO o1, PostPromoDTO o2) {
                return o1.getDetail().getProductName().compareTo(o2.getDetail().getProductName());
            }
        });
    }


    public void sortPromoDesc(ArrayList<PostPromoDTO> aSortear) {

        Collections.sort(aSortear, new Comparator<PostPromoDTO>() {
            @Override
            public int compare(PostPromoDTO o1, PostPromoDTO o2) {
                return o2.getDetail().getProductName().compareTo(o1.getDetail().getProductName());
            }
        });
    }






}
