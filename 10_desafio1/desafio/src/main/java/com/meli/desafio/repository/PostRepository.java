package com.meli.desafio.repository;

import com.meli.desafio.exceptions.PostErrorException;
import com.meli.desafio.exceptions.PostNotExistException;
import com.meli.desafio.models.Post;
import com.meli.desafio.utils.DataBase;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private List<Post> listPosts = DataBase.listPosts;

    @Override
    public void save(Post post) throws PostErrorException {
        for(Post p : listPosts){
            if(post.getPostId() == p.getPostId()){
                throw new PostErrorException(post.getPostId());
            }
        }
        listPosts.add(post);
    }

    @Override
    public Post getById(Integer postId) throws PostNotExistException {
        List<Post> post = listPosts.stream().filter(p -> p.getPostId() == postId).collect(Collectors.toList());
        if(post.size() == 0){
            throw new PostNotExistException(postId);
        }
        return post.get(0);
    }
}
