package com.meli.linktracker.service;

import com.meli.linktracker.exception.FormatLinkException;
import com.meli.linktracker.exception.InvalidCredentialsException;
import com.meli.linktracker.exception.InvalidatedLinkException;
import com.meli.linktracker.exception.LinkNotFoundException;
import com.meli.linktracker.model.Link;
import com.meli.linktracker.repository.ILinkRepository;
import com.meli.linktracker.service.dto.LinkDTORequest;
import com.meli.linktracker.service.dto.LinkDTOResponse;
import com.meli.linktracker.service.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService {
    private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";

    @Autowired
    ILinkRepository iLinkRepository;

    public LinkDTOResponse maskUrl(LinkDTORequest link) throws FormatLinkException{
        if(!urlValidator(link.getUrl())){
            throw new FormatLinkException(link.getUrl());
        }
        Link newLink= LinkMapper.toLink(link);
        LinkDTOResponse responseLink= LinkMapper.toLinkResponse(newLink);
        iLinkRepository.saveLink(newLink);
        return responseLink;
    }
    @Override
    public void redirectUrl(int linkId, String password, HttpServletResponse response) throws InvalidCredentialsException, LinkNotFoundException, InvalidatedLinkException {
        Link link= iLinkRepository.getLinkById(linkId);
        if(link==null){
            throw new LinkNotFoundException(linkId);
        }
        if (link.isInvalidate()){
            throw new InvalidatedLinkException(link);
        }
        if (!link.getPassword().equals(password)){
            throw new InvalidCredentialsException("Invalid password for link id "+linkId, HttpStatus.FORBIDDEN);
        }
        link.addCounter();
        response.setHeader("Location",link.getUrl());
        response.setStatus(HttpStatus.PERMANENT_REDIRECT.value());
    }

    @Override
    public int getStatistics(int linkId) throws LinkNotFoundException {
        Link link= iLinkRepository.getLinkById(linkId);
        if(link==null){
            throw new LinkNotFoundException(linkId);
        }
        return link.getCounter();
    }

    @Override
    public String invalidate(int linkId, String password) throws LinkNotFoundException, InvalidatedLinkException, InvalidCredentialsException {
        Link link= iLinkRepository.getLinkById(linkId);
        if(link==null){
            throw new LinkNotFoundException(linkId);
        }
        if (!link.getPassword().equals(password)){
            throw new InvalidCredentialsException("Invalid password for link id "+linkId, HttpStatus.FORBIDDEN);
        }
        if(link.isInvalidate()){
            throw new InvalidatedLinkException(link);
        }
        link.setInvalidate(true);
        return "The link with id "+link.getId()+" was invalidated successfully";
    }

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean urlValidator(String url)
    {

        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
}
