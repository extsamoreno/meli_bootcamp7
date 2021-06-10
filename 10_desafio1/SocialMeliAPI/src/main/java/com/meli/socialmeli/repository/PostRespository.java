package com.meli.socialmeli.repository;

import com.meli.socialmeli.exception.OverActualDateException;
import com.meli.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRespository implements IPostRepository{
    public static HashMap<Integer, Post> posts= new HashMap<>();

    @Override
    public Post getPostById(int postId) {
        return posts.get(postId);
    }

    /**
     * Method that save a post into the hashmap
     * @param post -> the post to be saved
     * @throws OverActualDateException -> if the date included in the post
     * is over the actual date
     */
    @Override
    public void savePost(Post post) throws OverActualDateException {

        Calendar c= Calendar.getInstance(); // Get an instance of calendar
        Date now= c.getTime(); // Calendar by default is created with the actual date
        c.setTime(post.getDate()); // Set the date of the post
        c.add(Calendar.DAY_OF_MONTH,1); // Add 1 day (Because Date works with 0 as initial day)
        Date realDate=c.getTime(); // Get the post date
        realDate.setHours(0); realDate.setMinutes(0); realDate.setSeconds(0); // Gross solution (never use Date) for necessarily set the hour as 0 (by default was getting 17:00)
        post.setDate(realDate); // Set the modified date into the post date
        if(post.getDate().compareTo(now)>0) throw new OverActualDateException(post.getDate()); // If the post date is over the actual date
        posts.put(post.getId_post(),post);
    }

    /**
     * Method that get all the posts of an specific user id with an
     * antiquity of 2 weeks ago
     * @param userId -> the user id by which you are going to get his posts
     * @return -> The list of filtered posts by antiquity and user id
     */
    @Override
    public List<Post> getPostsByUserId(int userId) {
        List<Post> postList = new ArrayList<>();
        posts.forEach((k,v) -> {if(v.getUserId()==userId){postList.add(v);}});// Take all the post with user id matches
        List<Post> requestedPosts= new ArrayList<>(); // This list is gonna save the sorted posts with an antiquity less than 2 weeks

        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR,-2); // Remove 2 weeks from the actual date
        Date twoWeeksAgo=calendar.getTime(); // Save the oldest date

        for (Post post : postList) {

            if (post.getDate().compareTo(twoWeeksAgo) > 0) { // if the date is 2 weeks or less from today's date
                requestedPosts.add(new Post(post)); // Add the post to requestedPosts
            }
        }
        return requestedPosts;
    }

    /**
     * Method that return all the post with an special promotion included
     * @param userId -> the seller id included in the post
     * @return -> a list of promotion posts
     */
    @Override
    public List<Post> getPromotionPostByUserId(int userId) {
        List<Post> postList = new ArrayList<>();
        posts.forEach((k,v) -> {if(v.getUserId()==userId && v.isHasPromo()){postList.add(v);}});// If the post user id and the id matches and hasPromo is true
        return postList;
    }

}
