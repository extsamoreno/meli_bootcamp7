package com.socialMeli.services;

import com.socialMeli.exceptions.FailCreatePostException;
import com.socialMeli.exceptions.InvalidDateException;
import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.PostsDTO;
import com.socialMeli.models.DTOs.PromoPostsCountDTO;
import com.socialMeli.models.DTOs.PromoPostsListDTO;
import com.socialMeli.models.Post;
import com.socialMeli.models.PromoPost;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;
import com.socialMeli.repository.iSocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService implements iPublicationService {

    @Autowired
    iSocialMeliRepository repository;

    @Override
    public Void newPost (Post post) throws FailCreatePostException, InvalidDateException {
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
    public PostsDTO listPostFollowedSellers (Integer userId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        LocalDate dateMinusTwoWeeks = LocalDate.now().minusWeeks(2);
        List<Post> result = new ArrayList<>();
        User user = repository.findUserById(userId);
        for (Seller seller: user.getFollowing()) {
            result.addAll(seller.getPosts().stream().filter(post -> post.getDate().isAfter(dateMinusTwoWeeks)).collect(Collectors.toList()));
            result.addAll(seller.getPromoPosts().stream().filter(post -> post.getDate().isAfter(dateMinusTwoWeeks)).collect(Collectors.toList()));
        }
        if (order.equals(""))
            return new PostsDTO (userId, (ArrayList<Post>) result);
        else
            return new PostsDTO (userId, orderPostsByDate((ArrayList<Post>) result, order));

    }

    @Override
    public ArrayList<Post> orderPostsByDate(ArrayList<Post> posts, String order) throws WrongCriteriaOrderException {
        Comparator<Post> c = (post1, post2) -> post1.getDate().isAfter(post2.getDate()) ? 1 : 0;

        switch (order){
            case "asc":
                Collections.sort(posts, c);
                break;
            case "desc":
                Collections.sort(posts, Collections.reverseOrder());
                break;
            default:
                throw new WrongCriteriaOrderException();
        }
        return posts;
    }

    @Override
    public Void newPromoPost (PromoPost promoPost) throws FailCreatePostException, InvalidDateException {
        validateDate(promoPost.getDate());
        repository.newPost(promoPost);
        return null;
    }

    @Override
    public PromoPostsCountDTO countPromoPosts (Integer sellerId) throws UserNotFoundException {
        Seller seller = repository.findSellerById(sellerId);
        return new PromoPostsCountDTO(sellerId, seller.getUsername(), seller.getPromoPosts().size());
    }

    @Override
    public PromoPostsListDTO listPromoPosts (Integer sellerId) throws UserNotFoundException {
        Seller seller = repository.findSellerById(sellerId);
        return new PromoPostsListDTO(sellerId, seller.getUsername(), seller.getPromoPosts());
    }
}
