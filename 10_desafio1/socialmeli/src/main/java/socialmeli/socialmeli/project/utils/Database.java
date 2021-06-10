package socialmeli.socialmeli.project.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
@NoArgsConstructor
public class Database {
    public static List<User> listUsers = new ArrayList<>(); //List of users
    public static HashMap<Integer, ArrayList<User>> mapUsersFollowers= new HashMap<>(); //Map to save usersId and their followers list
    public static HashMap<Integer, ArrayList<User>> mapUsersFollowed= new HashMap<>(); //Map to save usersId and their users followed list

    public static List<Post> listPosts = new ArrayList<>(); //List of posts

    public void loadUsersDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> list = null;

        try{
            list = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(User u: list){
            listUsers.add(u);
        }
    }

    public void instanceMapUsersFollowers(){
        for (User u: listUsers) {
            mapUsersFollowers.put(u.getUserId(),new ArrayList<>());
            mapUsersFollowed.put(u.getUserId(),new ArrayList<>());
        }
    }



    public void loadPostDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> list = null;

        try{
            list = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(Post p: list){
            listPosts.add(p);
        }
    }




}
