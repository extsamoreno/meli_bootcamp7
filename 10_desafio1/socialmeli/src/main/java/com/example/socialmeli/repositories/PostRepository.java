package com.example.socialmeli.repositories;

import com.example.socialmeli.dtos.UserDTO;
import com.example.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public  List<Post> getPostByUserId(Integer userId, String order) {
        List<Post> postList = postsMap.entrySet().stream().map(e -> e.getValue())
                .filter(e -> e.getUserId() == userId)
                .collect(Collectors.toList());

       /*for (int i = 0; i < postsMap.size(); i++) {
            Integer id = postsMap.get(i+1).getUserId();

            if (id == userId)
                postList.add(postsMap.get(i+1));
        }*/

        if (order != null && order.equals("date_asc")){
            postList.sort(Comparator.comparing(Post::getDate));
        }else{
            postList.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return postList;
    }
}
