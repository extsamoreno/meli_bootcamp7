package com.desafio.socialMeli.service;

import com.desafio.socialMeli.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.exceptions.UserNotFoundException;
import com.desafio.socialMeli.repository.ISocialMeliRepository;
import com.desafio.socialMeli.repository.SocialMeliRepository;
import com.desafio.socialMeli.repository.entities.Post;
import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.*;
import com.desafio.socialMeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.desafio.socialMeli.repository.SocialMeliRepository.POSTDTO_TABLE;
import static com.desafio.socialMeli.repository.SocialMeliRepository.USERDTO_TABLE;
import static com.desafio.socialMeli.service.mapper.PostMapper.toUserFollowedPostsDTO;

@Service
public class ProductService implements IProductService {

    @Autowired
    ISocialMeliRepository iSocialMeliRepository;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IOrderService iOrderService;

    @Override
    public String saveNewPost(Post post) throws UserNotFoundException{
        iSocialMeliRepository.getOrCreateDTOTable(POSTDTO_TABLE);
        PostDTO postDTOtoLoad = PostMapper.toPostDTO(post);
        if(iSocialMeliRepository.getDTOById(postDTOtoLoad.getUserId(), USERDTO_TABLE) == null) throw new UserNotFoundException();
        iSocialMeliRepository.updateDTORepository(postDTOtoLoad);
        return "Post guardado";
    }

    @Override
    public UserFollowedPostsDTO getFollowedPostsByUser(int userId) throws RepositoryUnableException, UserNotFoundException {

        UserFollowedDTO userFollowedList = iUserService.followedList(userId);
        List<PostDTO> allPostsDTOFollowed = new ArrayList<PostDTO>();
        List<PostDTO> postsByFollowed = new ArrayList<PostDTO>();

        for (User followed : userFollowedList.getFollowedList()) {
            postsByFollowed = iSocialMeliRepository.getPostDTOListByUserId(followed.getId());
            allPostsDTOFollowed.addAll(iOrderService.orderPostByDate(postsByFollowed, "date_asc_2W"));
        }

        UserFollowedPostsDTO userFollowedPostsDTO = PostMapper.toUserFollowedPostsDTO(allPostsDTOFollowed);

        return userFollowedPostsDTO;
    }
}
