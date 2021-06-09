package com.meli.socialmeli.repository;

import com.meli.socialmeli.exception.OverActualDateException;
import com.meli.socialmeli.model.Post;
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
    public void savePost(Post post) throws OverActualDateException {

        Calendar c= Calendar.getInstance();
        Date now= c.getTime();
        c.setTime(post.getDate());
        c.add(Calendar.DAY_OF_MONTH,1); // Se le agrega 1 dia ya que date trabaja desde dia 0
        Date realDate=c.getTime();
        realDate.setHours(0); realDate.setMinutes(0); realDate.setSeconds(0); //Nunca usen Date por fa
        post.setDate(realDate);
        if(post.getDate().compareTo(now)>0) throw new OverActualDateException(post.getDate());
        posts.put(post.getId_post(),post);
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        List<Post> postList = new ArrayList<>();
        posts.forEach((k,v) -> {if(v.getUserId()==userId){postList.add(v);}});//Se traen todos los posts del usuario
        List<Post> requestedPosts= new ArrayList<>(); //Aqui se guardaran las fechas ordenadas con 2 semanas de antiguedad

        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR,-2); // Se le restan 2 semanas a la fecha de hoy
        Date twoWeeksAgo=calendar.getTime(); // Se guarda esa fecha

        for (int i = 0; i < postList.size(); i++) {

            if (postList.get(i).getDate().compareTo(twoWeeksAgo)>0){ //Si la fecha se encuentra a 2 semanas o menos de la fecha de hoy
                requestedPosts.add(new Post(postList.get(i))); // Se agrega a requestedPosts
            }
        }
        return requestedPosts;
    }


}
