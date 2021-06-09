package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Models.Post;
import com.spring.desafioSpring.Models.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

    private static List<Post> dbPosts;

    static{
        dbPosts = new ArrayList<>();

        Product prod1 = new Product(1, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        Post post1 = new Post(5, 1, LocalDate.now().minusDays(8), prod1, 100, 1500.5, false, 0.0);


        Product prod2 = new Product(2, "Gabinete", "Gamer", "Racer", "Blue", "");
        Post post2 = new Post(5, 2, LocalDate.now().minusDays(7) , prod2, 32, 500.24, false, 0.0);

        dbPosts.add(post1);
        dbPosts.add(post2);
    }

    @Override
    public void insertPost(Post post) throws PostIdExistsException {
        if(!existsIdPost(post.getId_post())){
            dbPosts.add(post);
        }else{
            throw new PostIdExistsException(post.getId_post());
        }
    }

    @Override
    public List<Post> getPostsByUser(int userId) {
        return dbPosts.stream().filter(x -> x.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public int getPromosCountByUser(int userId) {
        return dbPosts.stream().filter(x -> x.getUserId().equals(userId) && x.isHasPromo() == true).collect(Collectors.toList()).size();
    }

    @Override
    public List<Post> getPromosByUser(int userId) {
        return dbPosts.stream().filter(x -> x.getUserId().equals(userId) && x.isHasPromo() == true).collect(Collectors.toList());
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
