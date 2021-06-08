package com.spring.spring4.Service;

import com.spring.spring4.Classes.Link;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface ILinkService {
    public void addLinkVisit(int id);

    public void createLink(String url, String pass);

    Link getLinkByUrl(String url);

    public Link getLinkByID(int id);

    public void invalidateLink(int id);

    boolean validateHTTP(String uri);

    public ResponseEntity<Object> getLinkByIDandPassword(int id, String pass) throws URISyntaxException;

    public boolean isValidLink(Link link);
}
