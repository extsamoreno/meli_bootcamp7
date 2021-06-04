package com.meli.linktracker.ejercicioSpring.service;

import com.meli.linktracker.ejercicioSpring.dto.LinkDTO;
import com.meli.linktracker.ejercicioSpring.model.Link;
import com.meli.linktracker.ejercicioSpring.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkMap {
    @Autowired
    ILinkRepository iLinkRepository;
    /*
    public LinkDTO toDTO(Link link){

    }
    */
    public static Link toModel(LinkDTO linkDTO, int linkid, String password){
      return new Link(linkid,password,linkDTO.getLink(),0);
    }
}
