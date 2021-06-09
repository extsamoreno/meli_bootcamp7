package com.example.challenge.Services;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import com.example.challenge.Repositories.IProductRepository;
import com.example.challenge.Services.DTOs.PostDTO;
import com.example.challenge.Services.DTOs.ResponseFollowedPostDTO;
import com.example.challenge.Services.DTOs.UserDTO;
import com.example.challenge.Services.Mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserService iUserService;


    private final Comparator<Post> COMPARATOR_DATE_ASC = Comparator.comparing(Post::getDate);

    private final Comparator<Post> COMPARATOR_DATE_DES = (a, b) -> b.getDate().compareTo(a.getDate());

    @Override
    public String addNewPost(PostDTO postDTO) throws UserNotFoundException {
        return iProductRepository.addNewPost(PostMapper.postDtoToPost(postDTO),
                iUserService.getUserById(postDTO.getUserId()));
    }

    @Override
    public ResponseFollowedPostDTO getMyFollowedPostList(int userId, String order) throws UserNotFoundException, InvalidOrderException {
        List<UserDTO> followed = iUserService.getFollowed(userId, "").getFollowers();
        List<Post> posts = new ArrayList<>();
        List<Post> temp = new ArrayList<>();
        for (UserDTO u : followed) {
            temp.addAll(iUserService.getUserById(u.getId()).getPosts());
        }
        LocalDate now = LocalDate.now();
        long daysBetween;
        for (Post p : temp) {
            daysBetween = ChronoUnit.DAYS.between(p.getDate(), now);
            if (daysBetween <= 14) {
                posts.add(p);
            }
        }
        if (order == "")
            sortPostByDate("date_des", posts);
        else
            sortPostByDate(order, posts);
        posts.sort(COMPARATOR_DATE_DES);
        List<PostDTO> postsDTO = new ArrayList<>();
        for (Post p : posts) {
            PostDTO postDTO = PostMapper.postToPostDTO(p);
            postsDTO.add(postDTO);
        }
        ResponseFollowedPostDTO responseFollowedPostDTO = new ResponseFollowedPostDTO();
        responseFollowedPostDTO.setUserId(userId);
        responseFollowedPostDTO.setPosts(postsDTO);
        return responseFollowedPostDTO;

    }

    public void sortPostByDate(String order, List<Post> list) throws InvalidOrderException {
        if (order.equals("date_asc")) {
            list.sort(COMPARATOR_DATE_ASC);
        } else if (order.equals("date_des")) {
            list.sort(COMPARATOR_DATE_DES);
        } else if (!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }

}
