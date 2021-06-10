package com.example.socialmeli.repositories;

import com.example.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    /**
     *
     * @param userId
     * @param order
     * @return List<Post> list of post that the merchant did
     */
    @Override
    public List<Post> getPostByUserId(Integer userId, String order) {
        List<Post> postList = postsMap.entrySet().stream().map(e -> e.getValue())
                .filter(e -> e.getUserId() == userId)
                .collect(Collectors.toList());

        if (order != null && order.equals("date_asc")){
            postList.sort(Comparator.comparing(Post::getDate));
        }else{
            postList.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return postList;
    }

    /**
     *
     * @param useriD
     * @return Integer with the count of promos that the merchant did
     */
    @Override
    public Integer promoCount(Integer useriD) {
        Integer count = 0;

        List<Post> postList = postsMap.entrySet().stream().map(e -> e.getValue())
                .filter(e -> e.getUserId() == useriD).collect(Collectors.toList());

        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getHasPromo()){
                count++;
            }
        }

        return count;
    }

    /**
     *
     * @param userId
     * @return a list of post with promos that the merchant did
     */
    @Override
    public List<Post> listPromoProductsByUserid(Integer userId) {

        List<Post> postList = postsMap.entrySet().stream().map(e -> e.getValue())
                .filter(e -> e.getUserId().equals(userId) && e.getHasPromo())
                .collect(Collectors.toList());

        return postList;
    }
}
