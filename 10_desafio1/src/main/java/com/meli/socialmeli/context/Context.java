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


    /**
     * Loads a context scenario to emulate the pre-existing data in the data storage sources
     * The context is reinitialized each time this method is called
     */
    public static void loadContext() {

        System.out.println("\n  ------------------ LOADING CHALLENGE CONTEXT... -------------------\n");

        // Add users:
        UserRepository.users.put(1, new User("user_1", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(2, new User("user_2", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(3, new User("user_3", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(4, new User("a_user_4", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(5, new User("z_user_5", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(6, new User("x_user_6", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(7, new User("b_user_7", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(8, new User("y_user_7", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(1547, new User("m_user_1547", new HashMap<>(), new HashMap<>()));
        UserRepository.users.put(6684, new User("m_user_6684", new HashMap<>(), new HashMap<>()));

        // Add posts from userId 1 (Promo & NoPromo):
        PostRepository.posts.put(1, generatePost("07-06-2021", 1));
        PostRepository.posts.put(2, generatePost("03-06-2021", 1));
        PostRepository.posts.put(3, generatePost("30-05-2021", 1));
        PostRepository.posts.put(4, generatePost("06-06-2021", 1));
        PostRepository.posts.put(5, generatePromoPost("01-06-2021", 1));
        PostRepository.posts.put(6, generatePromoPost("04-06-2021", 1));
        PostRepository.posts.put(7, generatePromoPost("31-05-2021", 1));
        PostRepository.posts.put(8, generatePromoPost("29-05-2021", 1));

        // Add posts from userId 2 (Promo & NoPromo):
        PostRepository.posts.put(9, generatePost("01-06-2021", 2));
        PostRepository.posts.put(10, generatePost("30-05-2021", 2));
        PostRepository.posts.put(11, generatePost("06-06-2021", 2));
        PostRepository.posts.put(12, generatePost("29-05-2021", 2));
        PostRepository.posts.put(13, generatePromoPost("01-06-2021", 1));
        PostRepository.posts.put(14, generatePromoPost("04-06-2021", 1));
        PostRepository.posts.put(15, generatePromoPost("31-05-2021", 1));

    }

    private static Post generatePost(String postDate, int userId) {

        Post post = new Post();

        post.setUserId(userId);
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

    private static Post generatePromoPost(String postDate, int userId) {

        Post post = generatePost(postDate, userId);
        post.setHasPromo(true);
        post.setDiscount(0.27);

        return post;
    }

}

