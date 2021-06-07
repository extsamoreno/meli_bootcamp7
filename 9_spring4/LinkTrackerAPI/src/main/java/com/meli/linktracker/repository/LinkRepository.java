package com.meli.linktracker.repository;

import com.meli.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{
    private static HashMap<Integer, Link> DDBB= new HashMap<>();

    @Override
    public Link getLinkById(int id) {
        return DDBB.get(id);
    }

    @Override
    public void saveLink(Link link) {
        DDBB.put(link.getId(),link);
    }
}
