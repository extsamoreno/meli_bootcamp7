package com.meli.socialmeli.repositories;

import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.meli.socialmeli.repositories.UserRespository.users;

@Repository
public class PostRepository implements IPostRepository {

    //protected static HashMap<Integer, UserMeli> posts = new HashMap<>();


    @Override
    public UserMeli newPostAdd(Post post) {

        int userId = post.getUserId();
        users.get(userId).setPosts(post);
        return users.get(userId);
    }

    @Override
    public UserMeli getPostListById(int userId) {
        //users.get(userId).getPosts()get(1).getDate();
        return null;
    }

    private static List<String> sortedByDate(List<String> dates){

//        Instant instant = Instant.now();
//        String output = formatter.format( instant );

        List<String> sortedDates = dates.stream()
//                .map(this::formatToInstant)     // Las mapeamos a LocalDateTime
                .sorted()                       // Las ordenamos según su orden natural
//                .map(this::formatToString)      // Las convertimos de vuelta a String
                .collect(Collectors.toList());  // Creamos una nueva lista con las String ya ordenadas
        return sortedDates;
    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("2020-02-12");
//        list.add("2017-11-02");
//        list.add("2018-05-11");
//        list.add("2017-12-55");
//        System.out.println(" = " + sortedByDate(list));
//    }

}
