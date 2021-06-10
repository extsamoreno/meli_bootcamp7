package com.socialmedia.socialmedia.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.Follower;
import com.socialmedia.socialmedia.repositories.entities.IPostRepository;
import com.socialmedia.socialmedia.repositories.entities.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    @Override
    public int add(Post object) {
        List<Post> posts = loadDatabasePosts();
        int newId = posts.size() + 1;

        object.setId(newId);

        posts.add(object);

        updateDatabasePosts(posts);

        return newId;
    }

    @Override
    public Post update(Post object) throws ObjectNotFoundException {
        List<Post> posts = loadDatabasePosts();

        Post postTemp = getById(object.getId());

        posts.set(posts.indexOf(postTemp), object);

        updateDatabasePosts(posts);

        return object;
    }

    @Override
    public Post getById(int id) throws ObjectNotFoundException {
        List<Post> posts = loadDatabasePosts();

        Post result = posts.stream()
                .filter(follower -> follower.getId() == id)
                .findFirst().get();

        if (Objects.isNull(result)) throw new ObjectNotFoundException(id);

        return result;
    }

    private List<Post> loadDatabasePosts() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Post>> typeReference = new TypeReference<>() {
        };
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return posts;
    }

    private void updateDatabasePosts(List<Post> posts) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(posts);

            FileWriter myWriter = new FileWriter("src/main/resources/posts.json", false);
            myWriter.write(jsonString);
            myWriter.close();

        } catch (Exception ex) {
            System.out.println("Error al convertir a json");
            ex.printStackTrace();
        }
    }

    @Override
    public Post getByPostId(int postId) {
        List<Post> posts = loadDatabasePosts();

        Optional<Post> result = posts.stream()
                .filter(follower -> follower.getPostId() == postId)
                .findFirst();

        if (!result.isPresent()) return null;

        return result.get();
    }

    @Override
    public List<Post> getByUserForTwoWeeksId(int userId) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -14);
        Date twoWeeks = c.getTime();

        List<Post> posts = loadDatabasePosts();

        var result = posts.stream()
                .filter(post -> post.getUserId() == userId && !post.getDate().before(twoWeeks))
                .collect(Collectors.toList());

        return result;
    }
}
