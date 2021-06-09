package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationControllet {
    @Autowired
    IPublicationService iPublicationService;

    @GetMapping("/list")
    public List<PublicationDTO> getPublications () {
        return iPublicationService.getPublications();
    }

    @GetMapping("/list/promo")
    public List<PublicationPromoDTO> getPublicationsPromo () {
        return iPublicationService.getPublicationsPromo();
    }

}
