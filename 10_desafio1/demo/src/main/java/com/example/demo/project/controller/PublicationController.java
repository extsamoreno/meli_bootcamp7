package com.example.demo.project.controller;

import com.example.demo.project.exception.CantInsertDateGreaterThanToday;
import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.PublicationIsNotPromoException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.service.IPublicationService;
import com.example.demo.project.service.dto.PublicationDTO;
import com.example.demo.project.service.dto.FollowedPublicationsDTO;
import com.example.demo.project.service.dto.PublicationPromoDTO;
import com.example.demo.project.service.dto.UserWithPromoPublicationCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    IPublicationService iPublicationService;

    //US 0005
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PublicationDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException, PublicationIsNotPromoException, CantInsertDateGreaterThanToday {
        iPublicationService.newPost(publicationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0006
    @GetMapping("/followed/{userid}/list")
    public ResponseEntity<FollowedPublicationsDTO> followedPublications(@PathVariable int userid, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        FollowedPublicationsDTO returnDTO =  iPublicationService.getFollowedPost(userid, order);
        return new ResponseEntity<>(returnDTO, HttpStatus.OK);
    }

    //US 0010
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@RequestBody PublicationPromoDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException, PublicationIsNotPromoException, CantInsertDateGreaterThanToday {
        iPublicationService.newPost(publicationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0011
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<UserWithPromoPublicationCountDTO> promoPublicationsCount(@PathVariable int userId) throws UserIdNotFoundException {
        UserWithPromoPublicationCountDTO userDTO =  iPublicationService.getPromoPublications(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //US 0012
    @GetMapping("/{userId}/list")
    public ResponseEntity<FollowedPublicationsDTO> promoPublicationsList(@PathVariable int userId, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        FollowedPublicationsDTO returnDTO =  iPublicationService.getPromoPublications(userId, order);
        return new ResponseEntity<>(returnDTO, HttpStatus.OK);
    }
}
