package com.bootcamp.socialmeli.util;

import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SortUtilities {

    public void sortListOfUsers(List<User> users, Optional<String> order) {

        switch (order.orElse("")) {
            case "name_desc":
                users.sort((u1, u2) -> u2.getUserName().compareTo(u1.getUserName()));
                break;
            default:
                users.sort((u1, u2) -> u1.getUserName().compareTo(u2.getUserName()));
        }
    }

    public void sortListOfPosts(List<Post> posts, Optional<String> order) {

        switch (order.orElse("")) {
            case "date_asc":
                posts.sort((p1, p2) -> p1.getDate().compareTo(p2.getDate()));
                break;
            default:
                posts.sort((p1, p2) -> p2.getDate().compareTo(p1.getDate()));
        }
    }
}
