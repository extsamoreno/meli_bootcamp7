package com.socialMeli.services;

import com.socialMeli.exceptions.FailCreatePostException;
import com.socialMeli.exceptions.InvalidDateException;
import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.*;
import com.socialMeli.models.DTOs.PostsDTO;
import com.socialMeli.models.DTOs.PromoPostsCountDTO;
import com.socialMeli.models.DTOs.PromoPostsListDTO;
import com.socialMeli.repository.iSocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PublicationService implements iPublicationService {

    @Autowired
    iSocialMeliRepository repository;

    @Override
    public Void newPost (StandardPost post) throws FailCreatePostException, InvalidDateException {
        validateDate(post.getDate());
        repository.newPost(post);
        return null;
    }

    @Override
    public void validateDate(LocalDate date) throws InvalidDateException {
        if (date.of(date.getYear(), date.getMonth(), date.getDayOfMonth()) == null)
            throw new InvalidDateException(date);
    }

    @Override
    public PostsDTO listPostFollowedSellers (Integer userId) throws UserNotFoundException {
        LocalDate dateMinusTwoWeeks = LocalDate.now().minusWeeks(2);
        List<Post> posts = new ArrayList<>();

        User user = (User) repository.findById(userId);
        for (Seller seller: user.getFollowing()) {
            seller.getPosts().stream().filter(post -> {
                post.getDate().isAfter(dateMinusTwoWeeks);
                return posts.add(post);
            });
        }

        return new PostsDTO (userId, (ArrayList<Post>) posts);
    }

    @Override
    public Seller orderPostsByDate(Integer sellerId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        Seller seller = (Seller) repository.findById(sellerId);
        Comparator<Post> c = (post1, post2) -> post1.getDate().isAfter(post2.getDate()) ? 1 : 0;

        switch (order){
            case "asc":
                Collections.sort(seller.getPosts(), c);
                break;
            case "desc":
                Collections.sort(seller.getPosts(), Collections.reverseOrder());
                break;
            default:
                throw new WrongCriteriaOrderException();
        }
        return seller;
    }

    @Override
    public Void newPromoPost (PromoPost promoPost) throws FailCreatePostException, InvalidDateException {
        validateDate(promoPost.getDate());
        repository.newPromoPost(promoPost);
        return null;
    }

    @Override
    public PromoPostsCountDTO countPromoPosts (Integer sellerId) throws UserNotFoundException {
        Seller seller = (Seller) repository.findById(sellerId);
        List<Post> list = seller.getPosts().stream().filter(post -> post.getDetail().getHasPromo()).collect(Collectors.toList());
        return new PromoPostsCountDTO(sellerId, seller.getUsername(), list.size());
    }

    @Override
    public PromoPostsListDTO listPromoPosts (Integer sellerId) throws UserNotFoundException {
        Seller seller = (Seller) repository.findById(sellerId);
        List<Post> list = seller.getPosts().stream().filter(post -> post.getDetail().getHasPromo()).collect(Collectors.toList());
        return new PromoPostsListDTO(sellerId, seller.getUsername(), list);
    }
}
