package com.example.socialmeli.repositories;

import com.example.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository{
    private HashMap<Integer, Post> postsMap = new HashMap<>();

    @Override
    public void newPost(Post post) {
        postsMap.put(post.getIdPost(),post);
    }

    @Override
    public Post getPostById(int postId) {
        return postsMap.get(postId);
    }

    @Override
    public  List<Post> getPostByUserId(Integer userId) {
        List<Post> postList = new ArrayList<>();

        for (int i = 0; i < postsMap.size(); i++) {
            Integer id = postsMap.get(i+1).getUserId();

            if (id == userId){
                postList.add(postsMap.get(i+1));
            }
        }

        postList.sort(Comparator.comparing(Post::getDate));

        return postList;
    }
}
