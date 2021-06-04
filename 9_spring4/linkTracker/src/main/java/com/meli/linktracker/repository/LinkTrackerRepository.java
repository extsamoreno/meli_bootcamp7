package com.meli.linktracker.repository;

import com.meli.linktracker.domain.Link;
import com.meli.linktracker.exception.IdNotFoundException;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private List<Link> list = new ArrayList();
    private Integer cont = 0;

    @Override
    public Integer save(URI newURI) {
        Link link = new Link(cont, newURI);
        list.add(link);
        cont++;
        return link.getId();
    }

    @Override
    public Link getLinkByID(Integer linkId) throws IdNotFoundException {
        return list.stream()
                .filter(l -> l.getId() == linkId && l.isValid())
                .findFirst()
                .orElseThrow(() -> new IdNotFoundException(linkId));
    }

    @Override
    public void addRedirect(Integer linkId) throws IdNotFoundException {
        Link link = getLinkByID(linkId);
        link.setRedirects(link.getRedirects() + 1);
    }

    @Override
    public void invalidateByLinkId(Integer linkId) throws IdNotFoundException {
        getLinkByID(linkId).setValid(false);
    }
}
