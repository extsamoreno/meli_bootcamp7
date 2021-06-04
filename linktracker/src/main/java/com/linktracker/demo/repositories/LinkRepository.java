package com.linktracker.demo.repositories;

import com.linktracker.demo.models.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer,String> linkHashMap = new HashMap<>();

    @Override
    public Link addLink(Link link) {

        linkHashMap.put(linkHashMap.size() + 1, link.getUrl());
        link.setId(linkHashMap.size());

        return link;
    }

    @Override
    public Link findLinkByUrl(String url) {
        Link link = null;
        for (Map.Entry<Integer, String> entry: linkHashMap.entrySet()) {
            String entryUrl = entry.getValue();

            if(entryUrl.equals(url)){
                link = new Link(entry.getKey(), entry.getValue());
            }
        }

        return link;
    }
}
