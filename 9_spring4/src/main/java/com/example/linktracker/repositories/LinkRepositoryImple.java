package com.example.linktracker.repositories;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImple implements LinkRepository{
    HashMap<Integer, LinkDTO> diccionarioLinks = new HashMap<>();
    int count = 0;

    public LinkResponseDTO agregarLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException {
        for (int i = 0; i < diccionarioLinks.size(); i++) {
            String linkDiccionario = diccionarioLinks.get(i).getLink();

            if(linkDiccionario.equals(linkRequestDTO.getLink())){
                throw new ExistentLinkException(linkDiccionario);
            }
        }

        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLink(linkRequestDTO.getLink());
        linkDTO.setLinkId(count);

        diccionarioLinks.put(count, linkDTO);

        count++;

        return new LinkResponseDTO(linkDTO.getLinkId());
    }
}
