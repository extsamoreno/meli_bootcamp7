package com.reto1.demo.Service;

import com.reto1.demo.Exception.DateNotExistException;
import com.reto1.demo.Exception.DuplicatedPostException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.LastPostDTO;
import com.reto1.demo.Model.DTO.Mapper.PostMapper;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.User;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


@Service
public class PostService implements IPostService{

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public String creatPost(Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException {
        LocalDate today = LocalDate.now();

        // Con el tipo de dato Date, las fechas 26/05 , se vuelven 25/05, por eso se debe sumar un día
        LocalDate datePost = toLocalDate(post.getDate()).plusDays(1);
        post.setDate(toDate(datePost));

        if(datePost.isAfter(today)){
           throw new DateNotExistException(today, datePost);
        }

        User user = iFollowRepository.getUserById(post.getUserId());
        if(!user.getPosts().contains(post)){
            user.addPost(post);
        }
        else throw new DuplicatedPostException(post.getId_post());
        return post.getDetail().getProductName();
    }

    @Override
    public LastPostDTO lastPosts(int userId) throws UserIdNotFoundException {
        User user = iFollowRepository.getUserById(userId);
        LocalDate last2Weeks = LocalDate.now().minusDays(14);
        ArrayList<Post> recentPost = recent(user, last2Weeks);
        orderByDateASC(recentPost);
        return PostMapper.toLastPostDTO(user,recentPost);
    }

    public void orderByDateASC(ArrayList posts){
        Comparator<Post> c = (p1, p2) -> p2.getDate().compareTo(p1.getDate());
        posts.sort(c);
    }


    public ArrayList<Post> recent(User user, LocalDate last2weeks){
        ArrayList<Post> recentPost = new ArrayList<>();
        for (Post post: user.getPosts()) {
            LocalDate datePost = toLocalDate(post.getDate());
            if (last2weeks.isBefore(datePost) ||
                    last2weeks.isEqual(datePost)){
                recentPost.add(post);
            }
        }
        return recentPost;
    }

    public LocalDate toLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    public Date toDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
