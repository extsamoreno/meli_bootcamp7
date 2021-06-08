package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.model.Npost;
import com.meli.desafio1.web.repository.IPostRepository;
import com.meli.desafio1.web.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService{
    @Autowired
    IPostRepository postRepository;

    @Override
    public List<PostDTO> getPost(){
        List<PostDTO> postDTO = new ArrayList<>();
        List<Npost> nposts = postRepository.getListaPosts();
        for(Npost npost:nposts){
            postDTO.add(PostMapper.toDTO(npost));
        }
        return postDTO;


    }

}
