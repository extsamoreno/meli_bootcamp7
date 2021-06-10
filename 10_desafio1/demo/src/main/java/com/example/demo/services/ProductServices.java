package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.exception.GenericException;
import com.example.demo.exception.OrderErrorException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.IGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServices implements IProductServices{

    final static String ORDER_DATE_ASCE ="date_asc";
    final static String ORDER_DATE_DESC ="date_desc";
    final static String ORDER_NAME_ASCE ="name_asc";
    final static String ORDER_NAME_DESC ="name_desc";

    @Autowired
    IGeneralRepository repository;

    /**
     *
     * public a new post
     * @param post
     * @throws UserNotFoundException
     */
    @Override
    public void newPost(PostDTO post) throws UserNotFoundException {
        repository.findById(post.getUserId());
        repository.newPost(post);
    }

    /**
     * get all posts no olders than 2 weeks from a userId order by post's name (default: order ascendant)
     * @param userId
     * @param order
     * @return
     * @throws OrderErrorException
     */

    @Override
    public PostListDTO getPostList(Integer userId, String order) throws OrderErrorException {

        List<UserDTO> listFollowed= repository.followedList(userId);
        List<PostDTO> listPost = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -2);

        if (order.equals(ORDER_DATE_ASCE)) {
            for (UserDTO user: listFollowed) {
                listPost = Stream.concat(listPost.stream(), repository.findPostByUserId(user.getUserId()).stream())
                        .filter(post -> post.getDate().after(calendar.getTime()))
                        .sorted(Comparator.comparing(PostDTO::getDate))
                        .collect(Collectors.toList());
            }
        }else if (order.equals(ORDER_DATE_DESC))
        for (UserDTO user: listFollowed) {
            listPost = Stream.concat(listPost.stream(), repository.findPostByUserId(user.getUserId()).stream())
                    .filter(post -> post.getDate().after(calendar.getTime()))
                    .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                    .collect(Collectors.toList());
        }else{
            throw new OrderErrorException(order);
        }

        return new PostListDTO(userId,listPost);
    }

    /**
     * public a new promotional post
     * @param promoPost
     * @throws GenericException
     */

    @Override
    public void newPromoPost(PromoPostDTO promoPost) throws GenericException {
        repository.findById(promoPost.getUserId());
        repository.newPromoPost(promoPost);
    }

    /**
     * count the number of promotional publications of a userId
     * @param userId
     * @return
     * @throws GenericException
     */
    @Override
    public PromoPostCountDTO countPromo(Integer userId) throws GenericException{
        UserDTO user = repository.findById(userId);
        PromoPostCountDTO promoCount = new PromoPostCountDTO(user);
        promoCount.setPromoproducts_count(repository.countPromo(user));
        return promoCount;
    }

    /**
     *
     * get all promotional post from a userId and order by product's name (default: order ascendant)
     * @param userId
     * @param order
     * @return
     * @throws GenericException
     */

    @Override
    public PromoPostListDTO getPromoPostList(Integer userId, String order) throws GenericException {
        UserDTO user = repository.findById(userId);
        PromoPostListDTO promoPostList = new PromoPostListDTO(user);
        List<PromoPostDTO> listPromo = repository.getPromoList(user);

        if (order.equals(ORDER_NAME_ASCE)) {
            promoPostList.setListPromo(listPromo.stream().filter(promo -> promo.isHasPromo())
                    .sorted((o1,o2)-> o1.getDetail().getProductName().compareTo(o2.getDetail().getProductName()))
                    .collect(Collectors.toList()));
        }else if (order.equals(ORDER_NAME_DESC)){
            promoPostList.setListPromo(listPromo.stream().filter(promo -> promo.isHasPromo())
                    .sorted((o1,o2)-> o2.getDetail().getProductName().compareTo(o1.getDetail().getProductName()))
                    .collect(Collectors.toList()));
        }else{
            throw new OrderErrorException(order);
        }
        return promoPostList;
    }
}
