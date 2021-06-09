package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.*;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Exceptions.PropertyNotFoundException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Models.Post;
import com.spring.desafioSpring.Repositories.IPostRepository;
import com.spring.desafioSpring.Services.Mappers.PostMapper;
import com.spring.desafioSpring.Utils.GlobalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserService iUserService;

    @Override
    public void insertPost(PostDTO postDTO) throws PostIdExistsException {
        iPostRepository.insertPost(PostMapper.postDtoToPost(postDTO));
    }

    @Override
    public PostsSellersFollowDTO getPostsSellersFollow(int userId, String order) throws UserNotFoundException, PropertyNotFoundException {
        PostsSellersFollowDTO psfDTO = new PostsSellersFollowDTO();
        psfDTO.setUserId(userId);
        psfDTO.setPosts(new ArrayList<>());

        UserDTO userDTO = iUserService.getUserById(userId);

        long weekFilter = Long.parseLong(GlobalUtils.getProperty("weeksFilterListPostsSellers"));

        for (UserIdNameDTO u : userDTO.getFollowed()) {
            List<Post> listPosts = iPostRepository.getPostsByUser(u.getUserId());

            for (Post p : listPosts) {
                if(p.getDate().isAfter(LocalDate.now().minusWeeks(weekFilter)))
                    psfDTO.getPosts().add(PostMapper.postToPostWithoutIdUserDTO(p));

            }
        }

        if(order != null)
            orderListPostsByDate(psfDTO.getPosts(), order);

        return psfDTO;
    }

    @Override
    public CountPromosDTO countPromosByUser(int userId) throws UserNotFoundException {
        UserDTO user = iUserService.getUserById(userId);

        CountPromosDTO dto = new CountPromosDTO();
        dto.setUserId(userId);
        dto.setUserName(user.getUserName());
        dto.setPromoproducts_count(iPostRepository.getPromosCountByUser(userId));

        return dto;
    }

    @Override
    public ListPromosDTO getPromosByUser(int userId) throws UserNotFoundException {
        UserDTO user = iUserService.getUserById(userId);

        ListPromosDTO listDTO = new ListPromosDTO();
        listDTO.setUserId(userId);
        listDTO.setUserName(user.getUserName());
        listDTO.setPosts(new ArrayList<>());

        List<Post> postList = iPostRepository.getPromosByUser(userId);

        for (Post p : postList) {
            listDTO.getPosts().add(PostMapper.postToPostWithoutIdUserDTO(p));
        }

        return listDTO;
    }

    private void orderListPostsByDate(List<PostWithoutIdUserDTO> list, String order) {
        switch (order){
            case ("date_asc") :
                list.sort( (a,b) -> a.getDate().compareTo(b.getDate()) );
                break;

            case ("date_desc") :
                list.sort( (a, b) -> b.getDate().compareTo(a.getDate()) );
                break;

            default:
        }
    }
}
