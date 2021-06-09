package com.challenge.repository;

import com.challenge.entity.Post;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> postList;

    @PostConstruct
    private void init() {
        this.postList = loadPostList();
    }

    @Override
    public List<Post> getRecentPosts(List<Integer> followedIds, LocalDate since) {
       return postList.stream().filter(p -> followedIds.contains(p.getUserId()) && p.getDate().isAfter(since)).collect(Collectors.toList());

    }

    @Override
    public Integer getPromoPostCount(Integer userId) {
        return (int) postList.stream().filter(p -> p.getUserId().equals(userId) && p.getHasPromo().equals(true)).count();
    }

    public List<Post> getAllPromoPosts(Integer userId) {
        return postList.stream().filter(p -> p.getHasPromo().equals(true) && p.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public void addNewProduct(Post post) throws PostIdAlreadyExistsException, IOException {

        Optional<Post> contains = postList.stream().filter(p -> p.getPostId().equals(post.getPostId())).findAny();
        if (contains.isEmpty()) {
            this.postList.add(post);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            //The file's url points to the project folder so data isn't lost upon executing mvn clean command
            objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/posts.json"), this.postList);
        } else {
            throw new PostIdAlreadyExistsException();
        }
    }

    private List<Post> loadPostList() {
        File file = null;
        try {
            //The file's url points to the project folder so data isn't lost upon executing mvn clean command
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
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

}
