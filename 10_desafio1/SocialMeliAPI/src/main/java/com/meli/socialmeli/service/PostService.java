package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.PromotionPost;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.PostDTOFollowedList;
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
        if(iUserRepository.getUserById(post.getUserId())==null){
            throw new UserNotFoundException(post.getUserId());
        }
        if(iPostRepository.getPostById(post.getId_post())!=null){
            throw new PostIdAlreadyExistException(post);
        }
        iPostRepository.savePost(post);
        return HttpStatus.OK;
    }

    @Override
    public PostDTOFollowedList getFollowedUserPosts(int userId, String order) throws IncorrectOrderTypeException {
        List<Post> totalPostList= new ArrayList<>();
        List<User> followedUsers= iUserRepository.getUserById(userId).getFollowed();
        List<Post> postList;
        for (int i = 0; i < followedUsers.size(); i++) {
            postList= iPostRepository.getPostsByUserId(followedUsers.get(i).getUserId());
            for (int j = 0; j < postList.size(); j++) {
                totalPostList.add(postList.get(j));
            }
        }

        Comparator<Date> c=null;
        if (order==null || order.equals("date_desc")){
            c=QuickSort.date_des;
        } else if (order.equals("date_asc")){
            c=QuickSort.date_asc;
        } else {
            throw new IncorrectOrderTypeException(order);
        }

        PostDTOFollowedList response= new PostDTOFollowedList();
        response.setUserId(userId);
        if (totalPostList.size()==0) return response;
        totalPostList=sortPosts(totalPostList,c);
        response.setPosts(totalPostList);
        return response;
    }

    @Override
    public HttpStatus addNewPromotionPost(PromotionPost promoPost) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        if (!isAValidPost(promoPost)){
            throw new MissingDataException(promoPost);
        }
        if(iUserRepository.getUserById(promoPost.getUserId())==null){
            throw new UserNotFoundException(promoPost.getUserId());
        }
        if(iPostRepository.getPostById(promoPost.getId_post())!=null){
            throw new PostIdAlreadyExistException(promoPost);
        }
        iPostRepository.savePost(promoPost);
        return HttpStatus.OK;
    }

    public boolean isAValidPost(Post post)  {
        if (post.getDate()==null || post.getDetail()==null){
            return false;
        } else{
            return true;
        }
    }

    public boolean isAValidPost(PromotionPost post)  {
        if (post.getDate()==null || post.getDetail()==null){
            return false;
        } else{
            return true;
        }
    }

    public List<Post> sortPosts(List<Post> postList, Comparator c){
        Post[] arrPostList=postList.toArray(new Post[postList.size()]); //Se convierte a arreglo para ordenarlo
        List<Post> sortedPostList= new ArrayList<>(); //Aqui se guardaran las fechas ordenadas

        QuickSort sorter= new QuickSort();
        sorter.sortPostByDate(arrPostList,c);
        Collections.addAll(sortedPostList,arrPostList); //Ya ordenado se agrega a sortedPostList

        return sortedPostList;
    }
}
