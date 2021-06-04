package com.example.linktracker.services;

import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImple implements LinkService{
    @Autowired
    LinkRepository linkRepository;

    private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                    "([).!';/?:,][[:blank:]])?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean urlValidator(String url) {

        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

    @Override
    public LinkResponseDTO crearLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException {
        if(!urlValidator(linkRequestDTO.getLink())){
            throw new InvalidLinkException(linkRequestDTO.getLink());
        }

        return linkRepository.agregarLink(linkRequestDTO);
    }

    /*@Override
    public UrlResponseDTO validarLink(UrlRequestDTO urlDTO) {
        UrlResponseDTO urlResponseDTO = new UrlResponseDTO();

        //crear el link y agregarlo a la urlresponsedto

        return urlResponseDTO;
    }

    @Override
    public EstadisticaResponseDTO obtenerEstadisticas(String idLink) {
        EstadisticaResponseDTO estadisticaResponseDTO = new EstadisticaResponseDTO();

        //logica para obtener la cantidad de veces que se redirecciono y agregarlo a estadisticaresponsedto

        return estadisticaResponseDTO;
    }

    @Override
    public UrlResponseDTO invalidarLink(String idLink) {
        UrlResponseDTO urlResponseDTO = new UrlResponseDTO();

        //crear el link y agregarlo a la urlresponsedto

        return urlResponseDTO;
    }*/
}
