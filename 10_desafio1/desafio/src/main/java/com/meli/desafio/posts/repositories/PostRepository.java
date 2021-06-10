package com.meli.desafio.posts.repositories;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.models.Post;
import com.meli.desafio.utils.ChallengeUtils;
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

    @Override
    public List<Post> getAllByUserId(Integer userId) {
        List<Post> list = listPosts.stream().filter(p -> p.getUserId() == userId)
                .filter(p -> p.getDate()
                        .after(ChallengeUtils.getDateBeforeTwoWeeks()))
                .sorted().collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Post> getAllPromosByUserId(Integer userId) {
        return this.getAllByUserId(userId).stream().filter(p -> p.isHasPromo()).collect(Collectors.toList());
    }
}
