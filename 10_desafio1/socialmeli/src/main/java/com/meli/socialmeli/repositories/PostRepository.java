package com.meli.socialmeli.repositories;

import com.meli.socialmeli.dto.UserPostListDTO;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.meli.socialmeli.repositories.UserRespository.users;

@Repository
public class PostRepository implements IPostRepository {

    @Override
    public UserMeli newPostAdd(Post post) {

        int userId = post.getUserId();
        users.get(userId).getPosts().add(post);
        return users.get(userId);
    }

    private static LocalDate stringToDate(String sDate) {
        List<Integer> dateList = Arrays.stream(sDate.split("-"))
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        return LocalDate.of(dateList.get(2), dateList.get(1), dateList.get(0));
    }

    private static Boolean ifTwoWeeks(LocalDate ld) {
        int weeks = 2;
        LocalDate nowMinus2Weeks = LocalDate.now().minusWeeks(weeks);
        if (ld.isAfter(nowMinus2Weeks)) {
            return true;
        }
        return false;
    }

    @Override
    public UserPostListDTO getPostListById(int userId) {
        List<Post> alp = users.get(userId).getPosts().stream().filter(post -> ifTwoWeeks(stringToDate(post.getDate())))
                .sorted((o2, o1) -> stringToDate(o1.getDate()).compareTo(stringToDate(o2.getDate())))
                .collect(Collectors.toList());
//List<Post> alp = users.get(userId).getPosts().stream()
//                .sorted(Comparator.comparing(o -> stringToDate(o.getDate()))).collect(Collectors.toList());

        return new UserPostListDTO(users.get(userId).getUserId(), alp);
    }


//    private static List<String> sortedByDate(List<String> dates) {
//
////        Instant instant = Instant.now();
////        String output = formatter.format( instant );
//
//        List<String> sortedDates = dates.stream()
////                .map(this::formatToInstant)     // Las mapeamos a LocalDateTime
//                .sorted()                       // Las ordenamos según su orden natural
////                .map(this::formatToString)      // Las convertimos de vuelta a String
//                .collect(Collectors.toList());  // Creamos una nueva lista con las String ya ordenadas
//        return sortedDates;
//    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("2020-02-12");
//        list.add("2017-11-02");
//        list.add("2018-05-11");
//        list.add("2017-12-55");
//        System.out.println(" = " + sortedByDate(list));
//    }

}
