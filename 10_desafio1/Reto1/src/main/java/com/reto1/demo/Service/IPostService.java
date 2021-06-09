package com.reto1.demo.Service;

import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.Post;

public interface IPostService {

    String creatPost(Post post) throws UserIdNotFoundException;
}
