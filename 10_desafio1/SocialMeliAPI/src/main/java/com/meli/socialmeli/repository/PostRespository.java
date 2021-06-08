package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.util.QuickSort;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRespository implements IPostRepository{
    public static HashMap<Integer, Post> posts= new HashMap<>();

    @Override
    public Post getPostById(int postId) {
        return posts.get(postId);
    }

    @Override
    public void savePost(Post post) {
        posts.put(post.getId_post(),post);
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        List<Post> postList = new ArrayList<>();
        posts.forEach((k,v) -> {if(v.getUserId()==userId){postList.add(v);}});//Se traen todos los posts del usuario
        List<Post> requestedPosts= new ArrayList<>(); //Aqui se guardaran las fechas ordenadas con 2 semanas de antiguedad

        Calendar calendar=Calendar.getInstance();
        Date now= calendar.getTime(); // Se obtiene la fecha del dia de hoy
        calendar.add(Calendar.WEEK_OF_YEAR,-2); // Se le restan 2 semanas a la fecha de hoy
        Date twoWeeksAgo=calendar.getTime(); // Se guarda esa fecha

        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getDate().compareTo(twoWeeksAgo)>0){ //Si la fecha se encuentra a 2 semanas o menos de la fecha de hoy
                requestedPosts.add(postList.get(i)); // Se agrega a requestedPosts
            }
        }
        return requestedPosts;
    }


}
