package com.example.demo.project.controller;

import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.exception.UsersCantFollowThemselvesException;
import com.example.demo.project.service.IUserService;
import com.example.demo.project.service.dto.SellerDTO;
import com.example.demo.project.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    //US 0001
    @PostMapping ("/{userid}/follow/{useridtofollow}")
    public HttpStatus followUser(@PathVariable Integer userid, @PathVariable Integer useridtofollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        iUserService.follow(userid, useridtofollow);
        return HttpStatus.OK;
    }

    //US 0002
    @GetMapping("/{id}/followers/count")
    public ResponseEntity<SellerDTO> followerCount(@PathVariable Integer id) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowerCount(id), HttpStatus.OK);
    }

    //US 0003
    @GetMapping("/{id}/followers/list")
    public ResponseEntity<SellerDTO> followers(@PathVariable Integer id) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowers(id), HttpStatus.OK);
    }

    //US 0004
    @GetMapping("/{id}/following/count")
    public ResponseEntity<UserDTO> followingCount(@PathVariable Integer id) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowingCount(id), HttpStatus.OK);
    }

    //US 0005
    @GetMapping("/{id}/following/list")
    public ResponseEntity<UserDTO> following(@PathVariable Integer id) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowing(id), HttpStatus.OK);
    }


    /*
    @PostMapping ("/{userid}/follow/{useridtofollow}")
    public ResponseEntity<Integer> addUrl(@RequestBody UrlDTO urlDTO)  throws UrlNotValidException {
        return new ResponseEntity<>(iUrlService.addUrlToRepository(urlDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RedirectView redirectById(@PathVariable Integer id)  throws UrlIdNotFoundException {


        return new RedirectView(iUrlService.getUrlById(id).getUrl());
    }*/
}
