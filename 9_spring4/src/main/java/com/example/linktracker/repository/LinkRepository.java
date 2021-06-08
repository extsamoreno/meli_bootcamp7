package com.example.linktracker.repository;

import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements  iLinkRepository {

    private HashMap<Integer, Link> hashLinks = new HashMap<>();

    @Override
    public Link saveLink(Link link) {

        if(link.getId() == null){
            link.setId(hashLinks.size()+1);
        }
        hashLinks.put(link.getId(), link);
        return link;
    }

    @Override
    public Link findLinkByID(Integer id) {
        return hashLinks.get(id);
    }
}
