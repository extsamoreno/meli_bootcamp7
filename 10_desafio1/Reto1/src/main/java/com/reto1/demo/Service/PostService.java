package com.reto1.demo.Service;

import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.User;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService implements IPostService{

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public String creatPost(Post post) throws UserIdNotFoundException {
        User user = iFollowRepository.getUserById(post.getUserId());
        user.addPost(post);
        return post.getDetail().getProductName();
    }
}
