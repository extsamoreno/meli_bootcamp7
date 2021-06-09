package com.meli.socialmeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImp implements IPostRepository {

    Map<Integer, List<Post>> postsDB;

    public PostRepositoryImp() {
        this.objectMapper = new ObjectMapper();
        this.postsDB = loadPosts();
    }

    @Override
    public void addPost(Post post) {
        List<Post> postsUser = new ArrayList<>();
        int indexPost = postsDB.values().stream().mapToInt(List::size).sum() + 1001;
        int indexProduct = indexPost + 1000;
        if (this.postsDB.containsKey(post.getUserId())) {
            postsUser = this.postsDB.get(post.getUserId());
            post.setPostId(indexPost);
            post.getProduct().setProductId(indexProduct);
            postsUser.add(post);
        }
        postsDB.put(post.getUserId(), postsUser);
        updateJsonPosts();
    }

    @Override
    public List<Post> getListPostByUserId(int userId) {
        return postsDB.get(userId);
    }

    @Override
    public List<Post> getListPromoPostByUserId(int userId) {
        return postsDB.get(userId).stream().filter(Post::isHasPromo).collect(Collectors.toList());
    }


    File file = null;
    ObjectMapper objectMapper = null;

    private Map<Integer, List<Post>> loadPosts() {
        try {
            this.file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<Map<Integer, List<Post>>> typeRef = new TypeReference<>() {
        };
        Map<Integer, List<Post>> postsFile = null;
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
}
