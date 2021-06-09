package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.MissingDataException;
import com.meli.socialmeli.exception.OverActualDateException;
import com.meli.socialmeli.exception.PostIdAlreadyExistException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.PostDTOFollowedList;
import com.meli.socialmeli.service.util.QuickSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public HttpStatus addNewPost(Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        if (!isAValidPost(post)){
            return HttpStatus.BAD_REQUEST;
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
    public PostDTOFollowedList getFollowedUserPosts(int userId) {
        List<Post> totalPostList= new ArrayList<>();
        List<User> followedUsers= iUserRepository.getUserById(userId).getFollowed();
        List<Post> postList;
        for (int i = 0; i < followedUsers.size(); i++) {
            postList= iPostRepository.getPostsByUserId(followedUsers.get(i).getUserId());
            for (int j = 0; j < postList.size(); j++) {
                totalPostList.add(postList.get(j));
            }
        }
        PostDTOFollowedList response= new PostDTOFollowedList();
        response.setUserId(userId);
        if (totalPostList.size()==0) return response;
        totalPostList=sortPosts(totalPostList,QuickSort.date_des);
        response.setPosts(totalPostList);
        return response;
    }

    public boolean isAValidPost(Post post)  {
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
