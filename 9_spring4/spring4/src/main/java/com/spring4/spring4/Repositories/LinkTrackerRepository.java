package com.spring4.spring4.Repositories;

import com.spring4.spring4.Exceptions.LinkNotFoundException;
import com.spring4.spring4.Models.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{

    private static Map<Integer, Link> linksDB;
    static{
        linksDB = new HashMap<>();
        linksDB.put(1, new Link(1, "https://www.google.com", "gg123", true, 3 ));
        linksDB.put(2, new Link(2, "https://www.mercadolibre.com.ar", "mm123", true, 4 ));
        linksDB.put(3, new Link(3, "https://www.youtube.com", "yy123", true, 5 ));
    }

    @Override
    public Link create(Link link) {
        int id = linksDB.size() + 1;
        link.setId(id);
        link.setRedirections(0);
        link.setActive(true);
        linksDB.put(id, link);

        return link;
    }

    @Override
    public Link getLink(int id) throws LinkNotFoundException {
        Link link = linksDB.get(id);
        if(link !=null)
            return link;
        else
            throw new LinkNotFoundException(id);
    }

    @Override
    public void addRedirectionCont(Link link) {
        linksDB.get(link.getId()).setRedirections(link.getRedirections()+1);
    }

    @Override
    public void invalidate(int id) {
        linksDB.get(id).setActive(false);
    }





}
