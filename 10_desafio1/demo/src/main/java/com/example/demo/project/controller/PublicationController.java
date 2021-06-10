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

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    IPublicationService iPublicationService;

    //US 0005
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@Valid @RequestBody PublicationDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException, PublicationIsNotPromoException, CantInsertDateGreaterThanToday {
        iPublicationService.newPost(publicationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0006
    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<FollowedPublicationsDTO> followedPublications(@PathVariable int user_id, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        FollowedPublicationsDTO returnDTO =  iPublicationService.getFollowedPost(user_id, order);
        return new ResponseEntity<>(returnDTO, HttpStatus.OK);
    }

    //US 0010
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@Valid @RequestBody PublicationPromoDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException, PublicationIsNotPromoException, CantInsertDateGreaterThanToday {
        iPublicationService.newPost(publicationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0011
    @GetMapping("/{user_id}/countPromo")
    public ResponseEntity<UserWithPromoPublicationCountDTO> promoPublicationsCount(@PathVariable int user_id) throws UserIdNotFoundException {
        UserWithPromoPublicationCountDTO userDTO =  iPublicationService.getPromoPublications(user_id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //US 0012
    @GetMapping("/{user_id}/list")
    public ResponseEntity<FollowedPublicationsDTO> promoPublicationsList(@PathVariable int user_id, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        FollowedPublicationsDTO returnDTO =  iPublicationService.getPromoPublications(user_id, order);
        return new ResponseEntity<>(returnDTO, HttpStatus.OK);
    }
}
