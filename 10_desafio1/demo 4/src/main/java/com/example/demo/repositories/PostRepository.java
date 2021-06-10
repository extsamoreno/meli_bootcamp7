package com.example.demo.repositories;

import com.example.demo.DTO.PostPromoDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.DTO.PostDTO;
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


    @Override
    public List<Post> loadPost() {
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
    public void savePosts() {
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
    public void addPost(Post post) {
        posts.add(post);
        savePosts();
    }

    @Override
    public List<PostDTO> getPostOfLasWeek(List<User> seller, String order) {
        List<Post> result = new ArrayList<Post>();

        Date validDate = getDateRange();
        for (User user : seller) {
            List<Post> postOfSeller = posts.stream().filter(post -> post.getUserId() == user.getUserId()).collect(Collectors.toList());

            result.addAll(postOfSeller.stream().filter(post -> post.getDate().after(validDate)).collect(Collectors.toList()));
        }
        result = sortByCriteria(result, order);

        return Mappers.toPostDTO(result);
    }

    private Date getDateRange() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);

        return calendar.getTime();
    }

    private List<Post> sortByCriteria(List<Post> list, String order) {

        if (order.equals("date_desc")) {
            list.sort((date1, date2) -> date2.getDate().compareTo(date1.getDate()));
        } else {
            list.sort(Comparator.comparing(Post::getDate));
        }
        return list;
    }

    @Override
    public int getCountPromosByUser(int userId) {

        List<Post> postWithPromo = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(post -> post.isHasPromo())
                .collect(Collectors.toList());


        return postWithPromo.size();
    }

    public List<PostPromoDTO> getListPromosByUser(int userId) {
        List<Post> postWithPromo = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(post -> post.isHasPromo())
                .collect(Collectors.toList());

        return Mappers.toPostPromoDTO(postWithPromo);
    }


}
