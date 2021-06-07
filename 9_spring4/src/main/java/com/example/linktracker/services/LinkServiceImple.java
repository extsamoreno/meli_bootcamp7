package com.example.linktracker.services;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.EstadisticaResponseDTO;
import com.example.linktracker.dtos.response.InvalidateLinkResponseDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.exceptions.UnexistentLinkException;
import com.example.linktracker.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImple implements LinkService{
    @Autowired
    LinkRepository linkRepository;

    @Override
    public LinkResponseDTO crearLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException {
        if(!urlValidator(linkRequestDTO.getLink())){
            throw new InvalidLinkException(linkRequestDTO.getLink());
        }

        return linkRepository.agregarLink(linkRequestDTO);
    }

    @Override
    public EstadisticaResponseDTO obtenerEstadisticas(int idLink) throws UnexistentLinkException {
        LinkDTO link = linkRepository.buscarLink(idLink);
        EstadisticaResponseDTO estadisticasLink = new EstadisticaResponseDTO();

        estadisticasLink.setLink(link.getLink());
        estadisticasLink.setIdLink(link.getLinkId());
        estadisticasLink.setCantidadRedirecciones(link.getCantidadRedirecciones());

        return estadisticasLink;
    }

    @Override
    public InvalidateLinkResponseDTO invalidarLink(int idLink) throws UnexistentLinkException{
        InvalidateLinkResponseDTO linkInvalido = linkRepository.invalidarLink(idLink);

        return linkInvalido;
    }

    private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                    "([).!';/?:,][[:blank:]])?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    private static boolean urlValidator(String url) {

        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
}
