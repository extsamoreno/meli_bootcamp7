package com.linktracker.demo.repositories;

import com.linktracker.demo.models.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer,String> linkHM = new HashMap<>();

    @Override
    public Link addLink(Link link) {

        linkHM.put(linkHM.size() + 1, link.getUrl());
        link.setId(linkHM.size());

        return link;
    }
}
