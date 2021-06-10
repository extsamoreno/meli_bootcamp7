package com.example.demo.socialmeli.controller;

import com.example.demo.socialmeli.exception.InvalidityDateException;
import com.example.demo.socialmeli.exception.MissingParameterException;
import com.example.demo.socialmeli.exception.PublicationExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.service.IPublicationService;
import com.example.demo.socialmeli.service.dto.PublicationListDTO;
import com.example.demo.socialmeli.service.dto.PublicationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PublicationController {
    @Autowired
    IPublicationService iPublicationService;
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost (@RequestBody PublicationRequestDTO publicationRequestDTO) throws UserNotFoundException, PublicationExistingException, MissingParameterException, InvalidityDateException {
        iPublicationService.addNewPost(publicationRequestDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationListDTO> publicationList (@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<PublicationListDTO>(iPublicationService.getPublicationList(userId, order),HttpStatus.OK);
    }
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost (@RequestBody PublicationRequestDTO publicationRequestDTO) throws UserNotFoundException, PublicationExistingException, MissingParameterException, InvalidityDateException {
        iPublicationService.addNewPost(publicationRequestDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/{userId}/countPromo/")
    public ResponseEntity<Void> newPromoPost (@PathVariable int userId) throws UserNotFoundException, PublicationExistingException, MissingParameterException, InvalidityDateException {

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
