package com.meli.socialmeli.context;

import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.ProductDetail;
import com.meli.socialmeli.models.User;
import com.meli.socialmeli.repository.PostRepository;
import com.meli.socialmeli.repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Context {

    public static void loadContext() {

        System.out.println("\n  ------------------ LOADING CHALLENGE CONTEXT... -------------------\n");

        UserRepository.users.put(1, new User("user_1", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(2, new User("user_2", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(3, new User("user_3", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(4, new User("a_user_4", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(5, new User("z_user_5", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(6, new User("x_user_6", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(7, new User("b_user_7", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(8, new User("y_user_7", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(1547, new User("merchant_1547", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(6684, new User("merchant_6684", new HashMap<>(), new HashMap<>()));

        PostRepository.posts.put(1, generatePost("01-06-2021"));
        PostRepository.posts.put(2, generatePost("30-05-2021"));
        PostRepository.posts.put(3, generatePost("06-06-2021"));
        PostRepository.posts.put(4, generatePost("29-05-2021"));

    }

    private static Post generatePost(String postDate) {

        Post post = new Post();

        post.setUserId(1547);
        post.setPrice(1500.50);
        post.setCategory(100);
        post.setDetail(new ProductDetail(62, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = formatter.parse(postDate);
            post.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return post;
    }
}

