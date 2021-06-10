package com.example.desafio1.repository;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static JavaUtils.JavaUtils.*;

@Repository
public class PostRepository implements iPostRepository {

    @Autowired
    iUserRepository iUserRepository;

    // Map with Posts
    HashMap<Integer, Post> mapPosts = new HashMap();

    // Create a new post
    @Override
    public Post savePost(Post post) throws PostAlreadyExistException, UserNotFoundException {

        User sellerUser = iUserRepository.findUserById(post.getUserId());

        // Exception: post id already exists
        if (mapPosts.get(post.getPostId()) != null) {
            throw new PostAlreadyExistException(post.getPostId());
        }

        mapPosts.put(post.getPostId(), post);
        return post;
    }

    // Returns a list with all posts created by the user
    @Override
    public ArrayList<Post> findPostsByUserId(Integer id) throws UserNotFoundException {

        User sellerUser = iUserRepository.findUserById(id);
        ArrayList<Post> listPostsUser = new ArrayList<>();

        // Filter posts by userId
        for (Map.Entry<Integer, Post> entry : mapPosts.entrySet()) {
            if (entry.getValue().getUserId() == sellerUser.getUserId()) {
                listPostsUser.add(entry.getValue());
            }
        }
        return listPostsUser;
    }

    // Search posts created up "weeksToFind" ago
    @Override
    public ArrayList<Post> findNewerPosts(int weeksToFind) {

        // New list to return
        ArrayList<Post> listPosts = new ArrayList<>();

        LocalDate today = LocalDate.now();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Create a list with posts filtered by weeks
        for (Map.Entry<Integer, Post> entry : mapPosts.entrySet()) {

            LocalDate datePost = convertToLocalDate(entry.getValue().getDate()).plusDays(1);
            // number of weeks since post created
            long weeksPost = ChronoUnit.WEEKS.between(datePost, today);

            // add posts with certain old (in weeks)
            if (weeksToFind - 1 >= weeksPost) {
                listPosts.add(entry.getValue());
            }
        }
        return listPosts;
    }

    // Search posts created up "weeksToFind" ago by userId
    @Override
    public ArrayList<Post> findNewerPostsByUserId(Integer id, Integer weeksToFind) throws UserNotFoundException {

        User sellerUser = iUserRepository.findUserById(id);

        // List with the last posts (filtered by weeks)
        ArrayList<Post> listPostsWeeks = findNewerPosts(weeksToFind);
        // List to return filtered by id and weeks
        ArrayList<Post> listPostsFiltered = new ArrayList<>();

        // Filter posts by userId
        for (Post p : listPostsWeeks) {
            if (sellerUser.getUserId() == p.getUserId()) {
                listPostsFiltered.add(p);
            }
        }
        return listPostsFiltered;
    }
}
