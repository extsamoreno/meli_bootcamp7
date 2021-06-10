package com.meli.socialmeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.socialmeli.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImp implements IPostRepository {

    Map<Integer, Post> postsDB;
    File file;
    ObjectMapper objectMapper;

    public PostRepositoryImp() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.postsDB = loadPosts();
    }

    @Override
    public void addPost(Post post) {
        int indexPost = postsDB.size() + 1001;
        int indexProduct = indexPost + 1000;
        post.setPostId(indexPost);
        post.getProduct().setProductId(indexProduct);
        postsDB.put(indexPost, post);
        updateJsonPosts();
    }

    @Override
    public List<Post> getListPostByUserId(int userId) {
        return postsDB.values().stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<Post> getListPromoPostByUserId(int userId) {
        return postsDB.values().stream().filter(post -> post.getUserId() == userId).filter(Post::isHasPromo).collect(Collectors.toList());
    }

    @Override
    public void updatePost(Post post) {
        postsDB.put(post.getPostId(), post);
        updateJsonPosts();
    }

    @Override
    public int countProductPromoByUserId(int userId) {
        return getListPromoPostByUserId(userId).size();
    }

    private Map<Integer, Post> loadPosts() {
        try {
            this.file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<Map<Integer, Post>> typeRef = new TypeReference<>() {
        };
        Map<Integer, Post> postsFile = null;
        try {
            postsFile = this.objectMapper.readValue(this.file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postsFile;
    }

    private void updateJsonPosts() {
        try {
            String jsonString = this.objectMapper.writeValueAsString(this.postsDB);

            FileWriter myWriter = new FileWriter("src/main/resources/posts.json", false);
            myWriter.write(jsonString);
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getPostByUserIdPostIdProductId(int userId, int postId, int productId) {
        return postsDB.values().stream()
                .filter(p1 -> p1.getPostId() == postId)
                .filter(p2 -> p2.getUserId() == userId)
                .filter(p3 -> p3.getProduct().getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post getPostByPostId(int postId) {
        return postsDB.get(postId);
    }
}
