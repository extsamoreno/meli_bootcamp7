package com.meli.spring_challenge.service.product;

import com.meli.spring_challenge.exception.product.PostAlreadyExistException;
import com.meli.spring_challenge.exception.product.ProductIDAlreadyExistException;
import com.meli.spring_challenge.exception.user.UserNotFoundException;
import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.model.Post;
import com.meli.spring_challenge.model.User;
import com.meli.spring_challenge.repository.follow.FollowRepository;
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
    @Autowired
    FollowRepository followRepository;


    @Override
    public void createNewPost(Post post) throws UserNotFoundException, PostAlreadyExistException, ProductIDAlreadyExistException {
        User user = userRepository.getUserByID(post.getUserID());
        Post postExists = newPostRepository.getPostById(post.getPostID());
        Post productExists = newPostRepository.getAll().stream()
                .filter(post1 -> post1.getDetail().getProductID() == post.getDetail().getProductID())
                .findFirst()
                .orElse(null);

        if(user == null)
            throw new UserNotFoundException(post.getUserID());

        if(postExists != null)
            throw new PostAlreadyExistException(postExists.getPostID());

        if(productExists != null)
            throw new ProductIDAlreadyExistException(post.getDetail().getProductID());


        newPostRepository.create(post);
    }

    @Override
    public FollowedSellerDto getFollowedSellerByID(int userID, String order) throws UserNotFoundException {
        User user = userRepository.getUserByID(userID);
        List<Follow> usersFollowed = followRepository.getFollowedByUserID(userID);
        List<Post> postsOfSeller = new ArrayList<>();

        for(Follow follow : usersFollowed){
           newPostRepository.getPostsByUserID(follow.getFollowedUserID())
                   .stream()
                   .forEach(postsOfSeller::add);
        }

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

}
