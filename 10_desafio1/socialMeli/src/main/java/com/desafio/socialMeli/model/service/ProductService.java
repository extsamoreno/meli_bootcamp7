package com.desafio.socialMeli.model.service;

import com.desafio.socialMeli.model.dao.models.Post;
import com.desafio.socialMeli.model.dao.models.User;
import com.desafio.socialMeli.model.dao.repository.ISocialMeliRepository;
import com.desafio.socialMeli.model.dto.*;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;
import com.desafio.socialMeli.model.mapper.PostMapper;
import com.desafio.socialMeli.model.service.helpers.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.desafio.socialMeli.model.dao.repository.SocialMeliRepository.POSTDTO_TABLE;
import static com.desafio.socialMeli.model.dao.repository.SocialMeliRepository.USERDTO_TABLE;

@Service
public class ProductService implements IProductService {

    @Autowired
    ISocialMeliRepository iSocialMeliRepository;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IOrderService iOrderService;

    @Override
    public String saveNewPost(Post post) throws UserNotFoundException {
        iSocialMeliRepository.getOrCreateDTOTable(POSTDTO_TABLE);
        PostDTO postDTOtoLoad = PostMapper.toPostDTO(post);
        if (iSocialMeliRepository.getDTOById(postDTOtoLoad.getUserId(), USERDTO_TABLE) == null)
            throw new UserNotFoundException();
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
            allPostsDTOFollowed.addAll(iOrderService.getPostSince(iOrderService.orderDTOByDate(postsByFollowed, "date_asc"), DateHelper.getDateBeforeTwoWeeks()));
        }
        UserFollowedPostsDTO userFollowedPostsDTO = PostMapper.toUserFollowedPostsDTO(allPostsDTOFollowed);
        return userFollowedPostsDTO;
    }

    @Override
    public UserFollowedPostsDTO getFollowedPostsByUser(int userid, String order) throws RepositoryUnableException, UserNotFoundException {
        UserFollowedPostsDTO userFollowedPostsDTO = getFollowedPostsByUser(userid);
        userFollowedPostsDTO.getPosts().sort(Comparator.comparing(p->p.stringToDate(p.getDate())));
        if(order.equals("date_asc")) Collections.reverse(userFollowedPostsDTO.getPosts());
        return userFollowedPostsDTO;
    }

    @Override
    public PostDTOCount getNumberOfPostsWithPromo(int userid){

        List<PostDTO> postDTOSList = iSocialMeliRepository.getPostDTOList();
        User user = iSocialMeliRepository.getUserById(userid);
        //System.out.println("el usuario es: " +user.getName());
        Integer qOfDiscount = 0;
        for(PostDTO p: postDTOSList){
            if(p.isHasPromo()) qOfDiscount++;
        }
        //PostDTOCount postCount = PostMapper.toPostDTOCount(user, qOfDiscount);
        //return postCount;
        return PostMapper.toPostDTOCount(user, qOfDiscount);
    }

    @Override
    public PostDTOList getPromoPostsByUser(int userid){
        List<PostDTO> postDTOSList = iSocialMeliRepository.getPostDTOList();
        List<PostDTO> postDTOSListAux =  new ArrayList<>();

        for(PostDTO p: postDTOSList) if(p.isHasPromo()) postDTOSListAux.add(p);

        PostDTOList postDTOList = new PostDTOList();
        postDTOList.setPostDTOList(postDTOSListAux);

        return new PostDTOList();
    }
}
