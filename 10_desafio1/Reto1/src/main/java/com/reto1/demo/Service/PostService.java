package com.reto1.demo.Service;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.PostException.DateNotExistException;
import com.reto1.demo.Exception.PostException.DuplicatedPostException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Exception.UserException.UserNotFollowException;
import com.reto1.demo.Model.DTO.Mapper.PostMapper;
import com.reto1.demo.Model.DTO.PostObjects.LastPostDTO;
import com.reto1.demo.Model.DTO.PostObjects.PromoPostCount;
import com.reto1.demo.Model.DTO.UserObjets.UserPromoPostListDTO;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.User;
import com.reto1.demo.Model.Util.Util;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;


@Service
public class PostService implements IPostService{

    @Autowired
    IFollowRepository iFollowRepository;

    /**
    * Create post and Promopost
    * */
    @Override
    public String creatPost(Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException {

        //Check if not exist the post
        User user = iFollowRepository.getUserById(post.getUserId());
        if(!user.getPosts().stream().anyMatch(c->c.getId_post() == post.getId_post())){
            user.addPost(post);
        }
        else throw new DuplicatedPostException(post.getId_post());

        LocalDate today = LocalDate.now();
        // With Date, the date 26/05 , return 25/05, for this reason plus 1 day
        LocalDate datePost = Util.toLocalDate(post.getDate()).plusDays(1);
        post.setDate(Util.toDate(datePost));

        //Check if date is after today
        if(datePost.isAfter(today)){
           throw new DateNotExistException(today, datePost);
        }

        return post.getDetail().getProductName();
    }


    /**
    * post and Promopost 2 weeks ago
    * */
    @Override
    public LastPostDTO lastPosts(int userId) throws UserIdNotFoundException, UserNotFollowException {
        User user = iFollowRepository.getUserById(userId);
        LocalDate last2Weeks = LocalDate.now().minusDays(14);
        //Return last2 weeks posts
        ArrayList<Post> recentPost = recent(user, last2Weeks);
        //Order by date, more recent first
        Util.orderDescByDate(recentPost);
        return PostMapper.toLastPostDTO(user,recentPost);
    }

    /**
    * Add order asc or desc
    * */
    @Override
    public LastPostDTO orderLastPost(int userId,String order) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException {
        LastPostDTO lastPostDTO = lastPosts(userId);
        if(order.equals("date_asc")){
            Util.orderAscByDateDTO(lastPostDTO.getPosts());
        }else if(order.equals("date_desc")){
            Util.orderDescByDateDTO(lastPostDTO.getPosts());
        }else{
            throw new OrderNotFoundException(order, "date");
        }
        return lastPostDTO;
    }
    /**
     * user show only promoPost
     * */
    @Override
    public UserPromoPostListDTO listPromoPost(int userId) throws UserNotFollowException, UserIdNotFoundException {
        User user = iFollowRepository.getUserById(userId);
        return PostMapper.toPromoPostDTO(user);
    }

    /**
    * promo count where the user can see the count promo products
    * that the seller has
    * */
    @Override
    public PromoPostCount countPromoPost(int userId) throws UserNotFollowException, UserIdNotFoundException {
        User user = iFollowRepository.getUserById(userId);
        return PostMapper.toPromoPostCountMapper(user);
    }

    /**
    * Filter post last 2 weeks ago
    * */
    public ArrayList<Post> recent(User user, LocalDate last2weeks){
        ArrayList<Post> recentPost = new ArrayList<>();
        for (Post post: user.getPosts()) {
            LocalDate datePost = Util.toLocalDate(post.getDate());
            if (last2weeks.isBefore(datePost) ||
                    last2weeks.isEqual(datePost)){
                recentPost.add(post);
            }
        }
        return recentPost;
    }

}
