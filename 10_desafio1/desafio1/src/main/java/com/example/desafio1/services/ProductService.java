package com.example.desafio1.services;

import com.example.desafio1.dtos.*;
import com.example.desafio1.exceptions.product.InvalidDiscountException;
import com.example.desafio1.exceptions.user.InvalidOrderException;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.exceptions.user.UserException;
import com.example.desafio1.mappers.PostMapper;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;
import com.example.desafio1.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class ProductService implements IProductService {
    // older to newer
    private final Comparator<Post> COMPARATOR_DATE_ASC = (a,b) -> a.getDate().compareTo(b.getDate());
    // newer to older
    private final Comparator<Post> COMPARATOR_DATE_DES = (a,b) -> b.getDate().compareTo(a.getDate());

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserService iUserService;

    @Override
    public String addNewPost(PostDTO postDTO) throws InvalidUserIdException {
        iProductRepository.addNewPost(iUserService.getUserById(postDTO.getUserId()),
                PostMapper.PostDTOToPost(postDTO));
        return "Se ha agregado el producto con id: " + postDTO.getDetail().getProductId() +
                " al usuario con id: " + postDTO.getUserId();
    }

    // Discount must be between 0 and 1
    @Override
    public String addNewPromoPost(PostPromoDTO postPromoDTO) throws InvalidUserIdException, InvalidDiscountException {
        double discount = postPromoDTO.getDiscount();
        if(discount < 0.00 || discount > 1.00) {
            throw new InvalidDiscountException(discount);
        }
        iProductRepository.addNewPost(iUserService.getUserById(postPromoDTO.getUserId()),
                PostMapper.PostPromoDTOToPost(postPromoDTO));
        return "Se ha agregado el producto en PROMOCION con id: " + postPromoDTO.getDetail().getProductId() +
                " al usuario con id: " + postPromoDTO.getUserId();
    }

    @Override
    public ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId, String order) throws UserException {
        List<UserDTO> followed = iUserService.getFollowedList(userId);
        List<Post> posts = new ArrayList<>();
        List<Post> temp = new ArrayList<>();
        for(UserDTO u : followed) {
            temp.addAll(iUserService.getPostsList(u.getUserId()));
        }
        LocalDate now = LocalDate.now();
        long daysBetween;
        for(Post p : temp) {
            daysBetween = ChronoUnit.DAYS.between(p.getDate(), now);
            if(daysBetween <= 14) {
                posts.add(p);
            }
        }
        sortPostByDate(order, posts);
        ResponseFollowedPostDTO responseFollowedPostDTO = new ResponseFollowedPostDTO();
        responseFollowedPostDTO.setUserId(userId);
        responseFollowedPostDTO.setPosts(posts);
        return responseFollowedPostDTO;
    }

    @Override
    public ResponsePromoCountDTO getPromoProductsCount(int userId) throws InvalidUserIdException {
        User user = iUserService.getUserById(userId);
        ResponsePromoCountDTO responsePromoCountDTO = new ResponsePromoCountDTO();
        responsePromoCountDTO.setUserId(user.getUserId());
        responsePromoCountDTO.setUserName(user.getUserName());
        responsePromoCountDTO.setPromoProductsCount(getListOfPromoProds(user.getPosts()).size());
        return responsePromoCountDTO;
    }

    @Override
    public ResponsePromoListDTO getListOfPromoProducts(int userId) throws InvalidUserIdException {
        User user = iUserService.getUserById(userId);
        ResponsePromoListDTO responsePromoListDTO = new ResponsePromoListDTO();
        responsePromoListDTO.setUserId(user.getUserId());
        responsePromoListDTO.setUserName(user.getUserName());
        responsePromoListDTO.setPosts(getListOfPromoProds(user.getPosts()));
        return responsePromoListDTO;
    }

    private List<Post> getListOfPromoProds(List<Post> posts) {
        List<Post> postPromoList = new ArrayList<>();
        for(Post p : posts) {
            if(p.isHasPromo()) {
                postPromoList.add(p);
            }
        }
        return postPromoList;
    }

    public void sortPostByDate(String order, List<Post> list) throws InvalidOrderException {
        if(order.equals("date_asc")) {
            list.sort(COMPARATOR_DATE_ASC);
        } else if(order.equals("date_des")) {
            list.sort(COMPARATOR_DATE_DES);
        } else if(!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }
}
