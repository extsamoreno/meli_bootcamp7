package com.meli.spring.services;

import com.meli.spring.Utils.StringUtils;
import com.meli.spring.exceptions.LinkIDNotFoundException;
import com.meli.spring.exceptions.LinkUnauthorizedException;
import com.meli.spring.models.Link;
import com.meli.spring.repository.LinkRepository;
import com.meli.spring.services.dto.LinkDto;
import com.meli.spring.services.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    LinkRepository linkRepository;

    @Override
    public LinkDto findlink(String linkID) throws LinkIDNotFoundException {
        Link link = linkRepository.findByLinkID(linkID);

        if(link == null || !link.isEnabled()){
            throw new LinkIDNotFoundException(linkID);
        }

        linkRepository.incrementVisitCounter(link);

        return LinkMapper.toDTO(link);
    }

    @Override
    public LinkDto saveLink(String url, String pass) {
        Link toSave = new Link();
        toSave.setUrl(url);
        toSave.setLinkID(StringUtils.randomAlphaNumeric(6));
        toSave.setPassword(pass);
        toSave.setContVisits(0);
        linkRepository.save(toSave);

        return LinkMapper.toDTO(toSave);
    }

    @Override
    public Integer getMetrics(String linkID) throws LinkIDNotFoundException {
        Link result = linkRepository.findByLinkID(linkID);

        if(result == null || !result.isEnabled()){
            throw new LinkIDNotFoundException(linkID);
        }

        return result.getContVisits();
    }

    @Override
    public String invalidateLink(String linkID, String pass) throws LinkUnauthorizedException {
        Link result = linkRepository.findByLinkID(linkID);

        if(result == null || !result.getPassword().equals(pass)){
            throw new LinkUnauthorizedException();
        }

        result.setEnabled(false);
        linkRepository.update(result);
        return "URL: " + result.getUrl() + "Fue desabilitada con exito!";
    }


}
