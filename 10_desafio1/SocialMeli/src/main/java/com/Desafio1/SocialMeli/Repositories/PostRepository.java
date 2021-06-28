package com.Desafio1.SocialMeli.Repositories;

import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostRepository implements IPostRepository{
    private AtomicInteger index; //Atributo para crear un id unico por cada post
    private List<Post> postList;

    public PostRepository(){
        this.postList = new ArrayList<>();
        this.index = new AtomicInteger(0); // Inicializa el atributo en 0
    }

    @Override
    public void createPost(Post post)throws DuplicateIdException {
        //Verifico que no exista un post con el mismo numero de id
        if(this.postList.stream().anyMatch(p->p.getIdPost() == post.getIdPost())){
            throw new DuplicateIdException("Ya existe un post con el id " + post.getIdPost() + ".");
        }
        //Aumento el id en 1 antes de agregar el post a la lista
        int id = index.incrementAndGet();
        post.setIdPost(id);
        this.postList.add(post);
    }
}
