package com.example.desafio1.repository;

import com.example.desafio1.exception.ProductPostNotFoundException;
import com.example.desafio1.model.ProductPost;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductPostRepository implements IProductPostRepository{
    private HashMap<Integer, ProductPost> postDir = new HashMap<>();

    @Override
    public void createNewPost(ProductPost productPost) {
        postDir.put(productPost.getId_post(), productPost);
    }

    @Override
    public ProductPost getProductPostById(int postId) throws ProductPostNotFoundException {
        if(!postDir.containsKey(postId))
        {
            throw new ProductPostNotFoundException(postId);
        }else{
            return postDir.get(postId);
        }
    }

    @Override
    public boolean isUsedPostId(int productId) {
        return postDir.containsKey(productId);
    }

    //used ids are invalid
    @Override
    public int validPostId() {
        return postDir.size() + 1;
    }

    //Method for test queries only
    @Override
    public HashMap<Integer, ProductPost> getProductPostCatalog() {
        return postDir;
    }

    /*
    @Override
    public ArrayList<ProductPost> getRecentOrderedPosts(int followedUserId) {
        ArrayList<ProductPost> posts = new ArrayList<>(getRecentPosts(followedUserId));
        QuickSort<ProductPost> sorter = new QuickSort();
        Comparator<ProductPost> c = new CompareDateDesc();
        sorter.sort(posts, c);
        return posts;
    }*/

    @Override
    public List<ProductPost> getRecentPosts(int followedUserId)
    {
        //recent means 2 weeks ago maximum
        return postDir.values().stream()
                .filter(post -> post.getUserId() == followedUserId)
                .filter(post -> post.getDate().after(getTwoWeeksAgoDate()))
                .collect(Collectors.toList());
    }

    private Date getTwoWeeksAgoDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }

}
