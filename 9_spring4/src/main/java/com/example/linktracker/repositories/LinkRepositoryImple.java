package com.example.linktracker.repositories;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.InvalidateLinkResponseDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.exceptions.UnexistentLinkException;
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
        linkDTO.setEstado(true);
        linkDTO.setCantidadRedirecciones(0);

        diccionarioLinks.put(count, linkDTO);

        count++;

        return new LinkResponseDTO(linkDTO.getLinkId());
    }

    public LinkDTO buscarLink(int idLink) throws UnexistentLinkException {
        LinkDTO linkEncontrado = new LinkDTO();

        for (int i = 0; i < diccionarioLinks.size(); i++) {
            int idLinkDiccionario = diccionarioLinks.get(i).getLinkId();

            if(idLinkDiccionario == idLink){
                linkEncontrado.setLinkId(diccionarioLinks.get(i).getLinkId());
                linkEncontrado.setLink(diccionarioLinks.get(i).getLink());

                return linkEncontrado;
            }
        }

        throw new UnexistentLinkException(idLink);
    }

    public InvalidateLinkResponseDTO invalidarLink(int idLink) throws UnexistentLinkException {
        InvalidateLinkResponseDTO linkInvalido = new InvalidateLinkResponseDTO();

        for (int i = 0; i < diccionarioLinks.size(); i++) {
            int idLinkDiccionario = diccionarioLinks.get(i).getLinkId();

            if(idLinkDiccionario == idLink){
                linkInvalido.setLinkId(idLinkDiccionario);
                linkInvalido.setLink(diccionarioLinks.get(i).getLink());
                linkInvalido.setEstado(false);

                return linkInvalido;
            }
        }

        throw new UnexistentLinkException(idLink);
    }
}
