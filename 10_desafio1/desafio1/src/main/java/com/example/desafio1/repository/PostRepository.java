package com.example.desafio1.repository;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static JavaUtils.JavaUtils.convertToLocalDate;
import static JavaUtils.JavaUtils.orderByDateASC;

@Repository
public class PostRepository implements iPostRepository {

    @Autowired
    iUserRepository iUserRepository;

    // Map with Posts
    HashMap<Integer, Post> mapPosts = new HashMap();

    // Create a new post
    @Override
    public Post savePost(Post post) throws PostAlreadyExistException, UserNotFoundException {

        // Exception: user id doesn't exist
        if (iUserRepository.findUserById(post.getUserId()) == null) {
            throw new UserNotFoundException(post.getUserId());
        }

        // Exception: post id already exists
        if (mapPosts.get(post.getIdPost()) != null) {
            throw new PostAlreadyExistException(post.getIdPost());
        }

        mapPosts.put(post.getIdPost(), post);
        return post;
    }

    @Override
    // Search posts created up "weeksToFind" weeks ago
    public ArrayList<Post> findWeeksPosts(int weeksToFind) {

        // New list to return
        ArrayList<Post> listPosts = new ArrayList<>();

        LocalDate today = LocalDate.now();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Create a list with posts "weeksToFind" ago
        for (Map.Entry<Integer, Post> entry : mapPosts.entrySet()) {

            LocalDate datePost = convertToLocalDate(entry.getValue().getDate()).plusDays(1);

            // number of weeks since post created
            long weeksPost = ChronoUnit.WEEKS.between(datePost, today);

            // add posts with certain old (in weeks)
            if (weeksToFind-1 >= weeksPost) {
                listPosts.add(entry.getValue());
            }
        }

        // Order posts by Date ASC
        orderByDateASC(listPosts);

        return listPosts;
    }

    @Override
    // Search posts created up "weeksToFind" ago by userId
    public ArrayList<Post> findWeeksPostsByUserId(Integer id, Integer weeksToFind) throws UserNotFoundException {

        // List with the last posts (filtered by weeks)
        ArrayList<Post> listPostsWeeks = findWeeksPosts(weeksToFind);

        // List to return filtered by id and weeks
        ArrayList<Post> listPostsFiltered = new ArrayList<>();

        // Filter posts by userId
        for (Post p : listPostsWeeks) {

            if (id == p.getUserId()) {
                listPostsFiltered.add(p);
            }
        }
        return listPostsFiltered;
    }
}
