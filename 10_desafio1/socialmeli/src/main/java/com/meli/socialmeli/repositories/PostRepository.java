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
                .map(Integer::parseInt).collect(Collectors.toList());

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

    private List<Post> FilterPerWeeks(int userId) {
        //weeks = 2 in ifTwoWeeks
        List<Post> postListTwoWeeks = users.get(userId).getPosts().stream()
                .filter(post -> ifTwoWeeks(stringToDate(post.getDate())))
                .collect(Collectors.toList());
        return postListTwoWeeks;
    }

    @Override
    public UserPostListDTO getPostListById(int userId, String order) {
        List<Post> alp = FilterPerWeeks(userId);
        if (order.equals("date_desc")) {
            alp = alp.stream().sorted((o2, o1) -> stringToDate(o1.getDate()).compareTo(stringToDate(o2.getDate())))
                    .collect(Collectors.toList());
            return new UserPostListDTO(users.get(userId).getUserId(), alp);
        }
        if (order.equals("date_asc")) {
            alp = alp.stream().sorted((o1, o2) -> stringToDate(o1.getDate()).compareTo(stringToDate(o2.getDate())))
                    .collect(Collectors.toList());
        }
        return new UserPostListDTO(users.get(userId).getUserId(), alp);
    }
}