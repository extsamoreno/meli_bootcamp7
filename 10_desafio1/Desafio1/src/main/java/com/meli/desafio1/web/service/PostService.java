package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.dto.PromoPostDTO;
import com.meli.desafio1.web.exception.*;
import com.meli.desafio1.web.model.Npost;
import com.meli.desafio1.web.model.User;
import com.meli.desafio1.web.repository.IFollowRepository;
import com.meli.desafio1.web.repository.IPostRepository;
import com.meli.desafio1.web.repository.IUserRepository;
import com.meli.desafio1.web.response.CountPromoPostResponse;
import com.meli.desafio1.web.response.PostListResponse;
import com.meli.desafio1.web.response.PostResponse;
import com.meli.desafio1.web.response.PromoPostListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
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
    @Autowired
    IUserRepository iUserRepository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    @Override
    public PostListResponse followedPostByUserId(int userId, String order) throws PostException {
        User user = iUserRepository.getUserById(userId);
        if(user==null){
            throw new PostUserNotFoundException(userId, HttpStatus.BAD_REQUEST);
        }
        if(!order.equals("") && !order.equals("date_desc") && !order.equals("date_asc")){
            throw new PostOrderNotValidException(order,HttpStatus.BAD_REQUEST);
        }
        List<PostResponse> postResponses = new ArrayList<>();
        List<Npost> nposts = ipostRepository.getPostList();
        List<Integer> userlist = iFollowRepository.getFollowById(userId).getFollows_id();
        for(Npost npost:nposts){
            if(userlist.contains(npost.getUserId())){
                postResponses.add(PostResponseMapper.toDTO(npost));
            }
        }
        System.out.println(postResponses);
        System.out.println(orderPost(postResponses,order));
        return new PostListResponse(userId,orderPost(postResponses,order));

    }
    public PostListResponse getListResponseById(List<PostListResponse> postListResponses,int userId){
        for(PostListResponse postListResponse:postListResponses){
            if(postListResponse.getUserId()==userId){
                return postListResponse;
            }
        }
        return null;
    }



    @Override
    public void createPost(PostDTO postDTO) throws Exception {

        LocalDate now = LocalDate.now();
        LocalDate datePost = postDTO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Npost npost = ipostRepository.getPostById(postDTO.getId_post());
        User user = iUserRepository.getUserById(postDTO.getUserId());


        if(user==null){
            throw new PostUserNotFoundException(postDTO.getUserId(),HttpStatus.BAD_REQUEST);
        }
        if(datePost.compareTo(now)>0){
            throw new InvalidPostValueException("Date of post can't be greater than current date.", HttpStatus.BAD_REQUEST);
        }
        if(postDTO.getPrice()<0){
            throw new InvalidPostValueException("Price value can't be lower than 0",HttpStatus.BAD_REQUEST);
        }
        if(npost==null) {
            ipostRepository.setPostList(PostMapper.toModel(postDTO));
        }
        else{
            throw new PostAlreadyExistsException(postDTO.getId_post(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void createPromoPost(PromoPostDTO promoPostDTO) throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate datePost = promoPostDTO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Npost npost = ipostRepository.getPostById(promoPostDTO.getId_post());
        User user = iUserRepository.getUserById(promoPostDTO.getUserId());


        if(user==null){
            throw new PostUserNotFoundException(promoPostDTO.getUserId(),HttpStatus.BAD_REQUEST);
        }
        if(datePost.compareTo(now)>0){
            throw new InvalidPostValueException("Date of post can't be greater than current date.", HttpStatus.BAD_REQUEST);
        }
        if(promoPostDTO.getPrice()<0){
            throw new InvalidPostValueException("Price value can't be lower than 0",HttpStatus.BAD_REQUEST);
        }
        if(npost==null) {
            ipostRepository.setPostList(PromoPostMapper.toModel(promoPostDTO));
        }
        else{
            throw new PostAlreadyExistsException(promoPostDTO.getId_post(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CountPromoPostResponse countPromo(int userId) throws UserNotFoundException {
        if(iUserRepository.getUserById(userId) == null){
            throw new UserNotFoundException(userId,HttpStatus.BAD_REQUEST);
        }
        CountPromoPostResponse countPromoPostResponse = new CountPromoPostResponse(userId,iUserRepository.userNameByUserId(userId),ipostRepository.getPromoPostByUserId(userId).size());
        return countPromoPostResponse;
    }

    @Override
    public PromoPostListResponse listPromo(int userId) throws UserNotFoundException {
        if(iUserRepository.getUserById(userId) == null){
            throw new UserNotFoundException(userId,HttpStatus.BAD_REQUEST);
        }
        List<Npost> nposts = ipostRepository.getPromoPostByUserId(userId);
        List<PostResponse> postResponses = new ArrayList<>();
        for(Npost npost:nposts){
            postResponses.add(PostResponseMapper.toDTO(npost));
        }
        return new PromoPostListResponse(userId,iUserRepository.userNameByUserId(userId),postResponses);
    }


    @Override
    public List<PostResponse> orderPost(List<PostResponse> postResponses, String order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        postResponses.sort((o1,o2)-> o1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().compareTo(o2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));

        if(order.equals("date_desc")){
            Collections.reverse(postResponses);
        }
        LocalDate now = LocalDate.now();
        List<PostResponse> postResponses1 = new ArrayList<>();
        for(PostResponse postResponse:postResponses){
            if(ChronoUnit.DAYS.between(postResponse.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),now)<15){
                postResponses1.add(postResponse);
            }
        }

        return postResponses1;
    }






}
