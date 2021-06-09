package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.model.Npost;
import com.meli.desafio1.web.repository.IFollowRepository;
import com.meli.desafio1.web.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.temporal.ChronoUnit;

@Service
public class PostService implements IPostService{
    @Autowired
    IPostRepository ipostRepository;
    @Autowired
    IUserService iUserService;
    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public List<PostDTO> followedPostByUserId(int userId, String order){
        List<PostDTO> postDTO = new ArrayList<>();
        List<Npost> nposts = ipostRepository.getListaPosts();
        List<Integer> userlist = iFollowRepository.getFollowById(userId).getFollows_id();
        for(Npost npost:nposts){
            if(userlist.contains(npost.getUserId())){
                postDTO.add(PostMapper.toDTO(npost));

            }
        }
        return orderPost(postDTO,order);

    }



    @Override
    public void createPost(PostDTO postDTO) {
        ipostRepository.setListaPosts(PostMapper.toModel(postDTO));
    }

    @Override
    public List<PostDTO> orderPost(List<PostDTO> postDTO, String order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        postDTO.sort((o1,o2)-> LocalDate.parse(o1.getDate(),formatter).compareTo(LocalDate.parse(o2.getDate(),formatter)));
        if(order.equals("date_desc")){
            Collections.reverse(postDTO);
        }
        LocalDate now = LocalDate.now();
        List<PostDTO> postDTOS = new ArrayList<>();
        for(PostDTO postDTO1:postDTO){
            if(ChronoUnit.DAYS.between(LocalDate.parse(postDTO1.getDate(),formatter),now)<14){
                postDTOS.add(postDTO1);
            }
        }

        return postDTOS;
    }


}
