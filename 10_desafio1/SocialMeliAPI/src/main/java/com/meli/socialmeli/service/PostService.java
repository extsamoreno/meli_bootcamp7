package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.PostDTOAllPostList;
import com.meli.socialmeli.service.dto.PostDTOFollowedList;
import com.meli.socialmeli.service.dto.PostDTOPromoCount;
import com.meli.socialmeli.service.util.QuickSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public HttpStatus addNewPost(Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        if (!isAValidPost(post)){
            throw new MissingDataException(post);
        }
        if(iUserRepository.getUserById(post.getUserId())==null){ // If the user id included in the post was not found
            throw new UserNotFoundException(post.getUserId());
        }
        if(iPostRepository.getPostById(post.getId_post())!=null){ // If the id post is already used
            throw new PostIdAlreadyExistException(post);
        }
        iPostRepository.savePost(post);
        return HttpStatus.OK;
    }

    @Override
    public PostDTOFollowedList getFollowedUserPosts(int userId, String order) throws IncorrectOrderTypeException, UserNotFoundException {
        List<Post> totalPostList= new ArrayList<>(); // List that will going to contain all the post for each followed user
        User user= iUserRepository.getUserById(userId);
        if (user==null){
            throw new UserNotFoundException(userId);
        }
        List<User> followedUsers= user.getFollowed(); // List of the followed user
        List<Post> postList;
        for (User followedUser : followedUsers) { // for each followed user
            postList = iPostRepository.getPostsByUserId(followedUser.getUserId()); // Take the list of their posts
            totalPostList.addAll(postList);
        }

        Comparator<Date> c=null; // Define an null comparator
        if (order==null || order.equals("date_desc")){ // If the optional sort was defined as desc or wasn't defined
            c=QuickSort.date_des;
        } else if (order.equals("date_asc")){ // If the optional sort was defined as asc
            c=QuickSort.date_asc;
        } else {
            throw new IncorrectOrderTypeException(order); // If the optional sort was defined with an unknown sort type
        }

        PostDTOFollowedList response= new PostDTOFollowedList();
        response.setUserId(userId);
        if (totalPostList.size()==0) return response; // If was not found any followed or followed post
        totalPostList=sortPosts(totalPostList,c); // Apply the sorting
        response.setPosts(totalPostList); // Set the new sorted list into the post response
        return response;
    }

    @Override
    public HttpStatus addNewPromotionPost(Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        if (!isAValidPost(post)){
            throw new MissingDataException(post);
        }
        if(iUserRepository.getUserById(post.getUserId())==null){  // If the user id included in the post was not found
            throw new UserNotFoundException(post.getUserId());
        }
        if(iPostRepository.getPostById(post.getId_post())!=null){ // If the id post is already used
            throw new PostIdAlreadyExistException(post);
        }
        iPostRepository.savePost(post);
        return HttpStatus.OK;
    }

    @Override
    public PostDTOAllPostList getAllPromotionPost(int userId) throws UserNotFoundException {
        User user= iUserRepository.getUserById(userId); // Take from the repository the user
        if (user==null){ // If the user was not found
            throw new UserNotFoundException(userId);
        }
        List<Post> postList=iPostRepository.getPromotionPostByUserId(userId); // Take from the repository all the posts with the condition to have hasPromo=true
        PostDTOAllPostList requestList= new PostDTOAllPostList();
        requestList.setUserId(userId);
        requestList.setUserName(user.getUserName());
        requestList.setPosts(postList);
        return requestList;
    }

    @Override
    public PostDTOPromoCount getPostPromoCount(int userId) throws UserNotFoundException {
        List<Post> postList= iPostRepository.getPromotionPostByUserId(userId); // Take from the repository all the posts with the condition to have hasPromo=true
        User user= iUserRepository.getUserById(userId); // Take from the repository the user
        if(user==null){ // If the user was not found
            throw new UserNotFoundException(userId);
        }
        PostDTOPromoCount requestPost= new PostDTOPromoCount();
        requestPost.setUserId(userId);
        requestPost.setUserName(user.getUserName());
        requestPost.setPromoproducts_count(postList.size());
        return requestPost;
    }

    /**
     * Method that return if a post is valid or not, considering valid as if
     * the date or the detail are null
     * @param post the post to be analyzed
     * @return true if is valid, false ifs not
     */
    public boolean isAValidPost(Post post)  {
        return post.getDate() != null && post.getDetail() != null;
    }

    /**
     * Method that take a list of post and a comparator, sort an array
     * extracted from the list and return the list sorted
     * @param postList the list to be sorted
     * @param c a comparator who is gonna define the kind of sort
     * @return the list sorted
     */
    public List<Post> sortPosts(List<Post> postList, Comparator c){
        Post[] arrPostList=postList.toArray(new Post[postList.size()]); // get an array from the list, the array to be ordered
        List<Post> sortedPostList= new ArrayList<>(); // This list is gonna save the sorted posts

        QuickSort sorter= new QuickSort();
        sorter.sortPostByDate(arrPostList,c);
        Collections.addAll(sortedPostList,arrPostList); // Add the new sorted array into the list

        return sortedPostList; // return the sorted list
    }
}
