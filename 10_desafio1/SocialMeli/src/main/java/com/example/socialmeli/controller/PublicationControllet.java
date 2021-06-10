package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.service.IPublicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationControllet {
    IPublicationService iPublicationService;

    public PublicationControllet(IPublicationService iPublicationService) {
        this.iPublicationService = iPublicationService;
    }

    //get all publications
    @GetMapping("/list")
    public List<PublicationDTO> getPublications() {
        return iPublicationService.getPublications();
    }

    //get all publication in promo
    @GetMapping("/list/promo")
    public List<PublicationPromoDTO> getPublicationsPromo() {
        return iPublicationService.getPublicationsPromo();
    }

}
