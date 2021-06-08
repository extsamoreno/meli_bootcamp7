package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Models.Post;
import com.spring.desafioSpring.Models.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {

    private static List<Post> dbPosts;

    static{
        dbPosts = new ArrayList<>();

        Product prod1 = new Product(1, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        Post post1 = new Post(5, 1, LocalDate.now(), prod1, 100, 1500.5);

        dbPosts.add(post1);
    }


    @Override
    public void insertPost(Post post) throws PostIdExistsException {
        if(!existsIdPost(post.getId_post())){
            dbPosts.add(post);
        }else{
            throw new PostIdExistsException(post.getId_post());
        }
    }

    private boolean existsIdPost(Integer postId){
        boolean check = false;

        for (Post p : dbPosts) {
            if(postId.equals(p.getId_post()))
                check = true;
        }

        return check;
    }

}
