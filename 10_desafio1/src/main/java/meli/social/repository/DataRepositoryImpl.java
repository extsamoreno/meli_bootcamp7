package meli.social.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.social.exception.PostIdRepeatedException;
import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.model.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class DataRepositoryImpl implements DataRepository {

    // ------------------------------ SEEDEANDO BASE DE DATOS ------------------------------
    List<UserModel> allUsers = loadUserDb();
    List<PostModel> allPosts = loadPostDb();

    @Override
    public List<UserModel> getUsersDb() {
        return allUsers;
    }

    @Override
    public List<PostModel> getPostsDb() {
        return allPosts;
    }


    // ------------------------------ MÉTODOS DE BASE DE DATOS ------------------------------
    @Override
    public UserModel findUserById(int userId) throws UserIdNotFoundException {
        UserModel foundUser = null;
        if (allUsers != null) {
            try {
                foundUser = allUsers.get(userId);
            } catch (Exception e) {
                throw new UserIdNotFoundException(userId);
            }
        }
        return foundUser;
    }

    @Override
    public PostModel findPostById(int postId) throws PostIdRepeatedException {
        PostModel foundPost = null;
        if(allPosts != null) {
            try{
                foundPost = allPosts.get(postId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(foundPost != null) throw new PostIdRepeatedException(postId);
        return foundPost;
    }

    // ------------------------------ CARGANDO USUARIOS ------------------------------
    private List<UserModel> loadUserDb() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserModel>> typeRef = new TypeReference<>() {};
        List<UserModel> allUsers = null;
        try {
            allUsers = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    // ------------------------------ CARGANDO POSTS ------------------------------
    private List<PostModel> loadPostDb() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PostModel>> typeRef = new TypeReference<>() {};
        List<PostModel> allPosts = null;
        try {
            allPosts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allPosts;
    }

    // ------------------------------ ESCRIBIENDO USUARIOS ------------------------------
    @Override
    public void saveUserDb(UserModel user, UserModel userToFollow) {
        for (UserModel u: allUsers) {
            if (u.getUserId() == user.getUserId()) allUsers.set(u.getUserId(), user);
            if (u.getUserId() == userToFollow.getUserId()) allUsers.set(u.getUserId(), userToFollow);
        }
        // Para refactorizar
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, allUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ ESCRIBIENDO POSTS ------------------------------

    @Override
    public void savePostDb(PostModel post) {
        allPosts.add(post);
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, allPosts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    // ------------------------------ CARGANDO POSTS EN MAP FALLIDO ------------------------------

//    private Hashtable<Integer, PostModel> loadPostDb() {
//        File file = null;
//        try {
//            file = ResourceUtils.getFile( "classpath:posts.json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        TypeReference<List<PostModel>> typeRef = new TypeReference<>() {};
//        List<PostModel> allPosts = null;
//        try {
//            allPosts = objectMapper.readValue(file, typeRef);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Hashtable<Integer, PostModel> posts = new Hashtable<>();
//        //PostModel post = new PostModel( 1, 2, "detail", LocalDate.of(1992,18,11), 50, 678.78);
//        //posts.put(1, post);
//        for (PostModel post: allPosts) {
//            posts.put(post.getPostId(), post);
//        }
//        return posts;
//    }


