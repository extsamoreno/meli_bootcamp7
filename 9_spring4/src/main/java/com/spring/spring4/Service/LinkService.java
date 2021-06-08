package com.spring.spring4.Service;

import com.spring.spring4.Classes.Link;
import com.spring.spring4.LinkMapper;
import com.spring.spring4.Repository.ILinkRepository;
import com.spring.spring4.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public void addLinkVisit(int id) {
        Link link = getLinkByID(id);
        link.setTimesAcceded(link.getTimesAcceded() + 1);
    }

    @Override
    public void createLink(String url, String pass) {
        iLinkRepository.saveLink(url, pass);
    }

    @Override
    public Link getLinkByUrl(String name) {
        return iLinkRepository.getLinks().stream().filter(url -> url.getUrl().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Link getLinkByID(int ID) {
        return iLinkRepository.getLinks().stream().filter(url -> url.getId() == ID).findFirst().orElse(null);
    }

    @Override
    public void invalidateLink(int id) {
        Link link = getLinkByID(id);
        link.setValid(false);
    }

    @Override
    public boolean validateHTTP(String uri) {
        final URL url;
        try {
            url = new URL(uri);
        } catch (Exception e1) {
            return false;
        }
        return "http".equals(url.getProtocol());
    }

    @Override
    public ResponseEntity<Object> getLinkByIDandPassword(int id, String pass) throws URISyntaxException {
        Link link = iLinkRepository.getLinks().stream().filter(url -> url.getId() == id).findFirst().orElse(null);
        if (link.getPassword().equals(pass)) {
            if (this.validateHTTP(link.getUrl())) {
                URI uri = new URI("http://www." + link.getUrl());
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setLocation(uri);
                this.addLinkVisit(id);
                return new ResponseEntity<>(httpHeaders, HttpStatus.PERMANENT_REDIRECT);
            }
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public boolean isValidLink(Link link) {
        return link.isValid();
    }

}
