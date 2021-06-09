package com.meli.spring_challenge.service.product;

import com.meli.spring_challenge.exception.UserNotFoundException;
import com.meli.spring_challenge.model.Post;
import com.meli.spring_challenge.model.User;
import com.meli.spring_challenge.repository.newpost.NewPostRepository;
import com.meli.spring_challenge.repository.user.UserRepository;
import com.meli.spring_challenge.service.dto.FollowedSellerCountDto;
import com.meli.spring_challenge.service.dto.FollowedSellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductServiceImpl implements ProductService {

    @Autowired
    NewPostRepository newPostRepository;
    @Autowired
    UserRepository userRepository;

    //TODO - Agregar control de Excepciones de Post,Product
    @Override
    public void createNewPost(Post post) throws UserNotFoundException {
        User user = userRepository.getUserByID(post.getUserID());

        if(user == null)
            throw new UserNotFoundException(post.getUserID());

        newPostRepository.create(post);
    }

    @Override
    public FollowedSellerDto getFollowedSellerByID(int userID, String order) throws UserNotFoundException {
        User user = userRepository.getUserByID(userID);
        List<Post> postsOfSeller = newPostRepository.getPostsByUserID(userID);
        FollowedSellerDto result = new FollowedSellerDto();

        if(user == null)
            throw new UserNotFoundException(userID);

        if(order != null && order.equals("date_asc")){
            Collections.sort(postsOfSeller, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    return o1.getDate().compareTo(o2.getDate());
                }
            });
        }else{
            Collections.sort(postsOfSeller, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    return o2.getDate().compareTo(o1.getDate());
                }
            });
        }

        Date start = new Date();
        Date end = getDateBeforeTwoWeeks(start);

        postsOfSeller = postsOfSeller.stream()
                .filter(post -> post.getDate().before(start) && post.getDate().after(end))
                .collect(Collectors.toList());

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setPosts(postsOfSeller);

        return result;
    }

    @Override
    public FollowedSellerCountDto getFollowedSellerCount(int userID) throws UserNotFoundException {
        FollowedSellerCountDto result = new FollowedSellerCountDto();
        User user = userRepository.getUserByID(userID);
        int count = 0;
        List<Post> listPost = newPostRepository.getPostsByUserID(userID);

        if(user == null)
            throw new UserNotFoundException(userID);

        for(Post post : listPost)
            if(post.isHasPromo()){
                count++;
            }

        result.setUserID(userID);
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setPromoproducts_count(count);

        return result;
    }

    @Override
    public FollowedSellerDto getFollowedSellerPromoByID(int userID) throws UserNotFoundException {
        User user = userRepository.getUserByID(userID);
        List<Post> postsOfSeller = newPostRepository.getPostsByUserID(userID);
        FollowedSellerDto result = new FollowedSellerDto();

        if(user == null)
            throw new UserNotFoundException(userID);

        postsOfSeller = postsOfSeller.stream().
                filter(post -> post.isHasPromo())
                .collect(Collectors.toList());

        Collections.sort(postsOfSeller, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setPosts(postsOfSeller);

        return result;
    }


    private Date getDateBeforeTwoWeeks(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }

    private Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
