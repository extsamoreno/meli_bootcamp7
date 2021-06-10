package com.example.challenge.Services;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.NotPromoPostException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import com.example.challenge.Repositories.IProductRepository;
import com.example.challenge.Repositories.IUserRepository;
import com.example.challenge.Services.DTOs.*;
import com.example.challenge.Services.Mappers.PostMapper;
import com.example.challenge.Services.Mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService implements IProductService {

    IProductRepository iProductRepository;
    IUserRepository iUserRepository;
    IUserService iUserService;

    UserMapper um = new UserMapper();

    private final Comparator<Post> COMPARATOR_DATE_ASC = Comparator.comparing(Post::getDate);

    private final Comparator<Post> COMPARATOR_DATE_DES = (a, b) -> b.getDate().compareTo(a.getDate());

    public ProductService(IProductRepository iProductRepository, IUserRepository iUserRepository, IUserService iUserService) {
        this.iProductRepository = iProductRepository;
        this.iUserRepository = iUserRepository;
        this.iUserService = iUserService;
    }

    @Override
    public String addNewPost(PostDTO postDTO) throws UserNotFoundException {
        return iProductRepository.addNewPost(PostMapper.postDtoToPost(postDTO),
                iUserService.getUserById(postDTO.getUserId()));
    }

    @Override
    public String addNewPromoPost(PostPromotionDTO postPromoDTO) throws UserNotFoundException, NotPromoPostException {
       if(!postPromoDTO.getHasPromo())
           throw new NotPromoPostException(postPromoDTO.getId());
        return iProductRepository.addNewPromoPost(PostMapper.postPromotionDtoToPost(postPromoDTO),
                iUserService.getUserById(postPromoDTO.getUserId()));
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
        if (order.equals(""))
            sortPostByDate("date_desc", posts);
        else
            sortPostByDate(order, posts);
        List<PostPromotionDTO> postsDTO = new ArrayList<>();
        for (Post p : posts) {
            PostPromotionDTO postDTO = PostMapper.postToPostPromotionDTO(p);
            postsDTO.add(postDTO);
        }
        ResponseFollowedPostDTO responseFollowedPostDTO = new ResponseFollowedPostDTO();
        responseFollowedPostDTO.setUserId(userId);
        responseFollowedPostDTO.setPosts(postsDTO);
        return responseFollowedPostDTO;

    }

    @Override
    public PromoCountDTO getCountPromo(int userId) throws UserNotFoundException {
        User u = iUserRepository.findUserById(userId);
        return um.userToPromoCount(u);
    }

    @Override
    public ResponsePromotionListDTO getPromotionsPost(int userId) throws UserNotFoundException {
        User u = iUserRepository.findUserById(userId);
        return um.userToResponsePromo(u);
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
