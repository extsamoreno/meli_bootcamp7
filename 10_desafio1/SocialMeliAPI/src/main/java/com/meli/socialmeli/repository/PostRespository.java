package com.meli.socialmeli.repository;

import com.meli.socialmeli.exception.OverActualDateException;
import com.meli.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
        post.setDate(c.getTime());
        if(post.getDate().compareTo(now)>0) throw new OverActualDateException(post.getDate());
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

        calendar=Calendar.getInstance(); // se reinicia la variable

        for (int i = 0; i < postList.size(); i++) {

            if (postList.get(i).getDate().compareTo(twoWeeksAgo)>0){ //Si la fecha se encuentra a 2 semanas o menos de la fecha de hoy
                calendar.setTime(postList.get(i).getDate());
                calendar.add(Calendar.DAY_OF_MONTH, -1); // Se le quita un dia para que se imprima con el formato adecuado
                postList.get(i).setDate(calendar.getTime());
                requestedPosts.add(new Post(postList.get(i))); // Se agrega a requestedPosts
                calendar.setTime(postList.get(i).getDate());
                calendar.add(Calendar.DAY_OF_MONTH, 1); // Se le suma un dia para no modificar la fecha original
                postList.get(i).setDate(calendar.getTime());
            }
        }
        return requestedPosts;
    }


}
