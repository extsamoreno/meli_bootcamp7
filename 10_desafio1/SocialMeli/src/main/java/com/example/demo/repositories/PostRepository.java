package com.example.demo.repositories;

import com.example.demo.DTO.PostPromoDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.DTO.PostDTO;
import com.example.demo.exceptions.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

    String postPathFile = System.getProperty("user.dir") + "/src/main/resources/data/post.json";

    List<Post> posts = loadPost();

    public PostRepository() throws IOException {
    }


    @Override
    public List<Post> loadPost() throws IOException{
        File file = null;
        try {
            file = ResourceUtils.getFile(postPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {
        };
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void savePosts() throws IOException{
        File file = null;
        try {
            file = ResourceUtils.getFile(postPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, posts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean postExists(Post newPost) {
        Post item = posts.stream()
                .filter(post -> post.getId_post() == newPost.getId_post())
                .findAny().orElse(null);

        if (item == null) {
            return false;
        }
        return true;
    }

    @Override
    public void addPost(Post post) throws IOException{
        posts.add(post);
        savePosts();
    }

    @Override
    public List<Post> getPostOfLasWeek(List<User> seller) throws NotFoundException {
        List<Post> result = new ArrayList<Post>();

        if (seller == null) {
            throw new NotFoundException("Has not followed");
        }
        Date validDate = getDateRange();
        for (User user : seller) {
            List<Post> postOfSeller = posts.stream().filter(post -> post.getUserId() == user.getUserId()).collect(Collectors.toList());

            result.addAll(postOfSeller.stream().filter(post -> post.getDate().after(validDate)).collect(Collectors.toList()));
        }
        result = result;

        return result;
    }

    private Date getDateRange() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);

        return calendar.getTime();
    }

    @Override
    public int getCountPromosByUser(int userId) throws NotFoundException {

        if (posts == null) {
            throw new NotFoundException("Not exist any post");
        }
        List<Post> postWithPromo = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(post -> post.isHasPromo())
                .collect(Collectors.toList());


        return postWithPromo.size();
    }

    public List<Post> getListPromosByUser(int userId) throws NotFoundException{
        if (posts == null) {
            throw new NotFoundException("Not exist any post");
        }
        List<Post> postWithPromo = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(post -> post.isHasPromo())
                .collect(Collectors.toList());

        return postWithPromo;
    }


}
