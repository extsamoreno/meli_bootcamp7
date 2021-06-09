package com.api.socialmeli.repository;

import com.api.socialmeli.exception.PostIdExistsException;
import com.api.socialmeli.model.PostModel;
import com.api.socialmeli.model.ProductModel;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PostRepositoryImple implements PostRepository{

    private static List<PostModel> dbPosts;

    static{
        dbPosts = new ArrayList<>();
        ProductModel product1 = new ProductModel(1000, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        PostModel post1 = new PostModel(2000, 1, LocalDate.parse("2021-03-10"), product1, 100, 1500.5);
        dbPosts.add(post1);
    }

    public List<PostModel> getDbPosts() {
        return dbPosts;
    }

    public void setDbPosts(ArrayList<PostModel> dbPosts) {
        PostRepositoryImple.dbPosts = dbPosts;
    }


}
