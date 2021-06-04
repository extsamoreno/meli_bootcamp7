package com.example.LinkTracker.repositories;

import com.example.LinkTracker.models.Link;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;

import java.util.HashMap;
import java.util.Map;

public class LinkRepository implements ILinkRepository{
    private static Map<Integer, Link> links = new HashMap<>();
    static {
            links.put(0,new Link("google.com","1234"));
            links.put(1,new Link("google.com","1234"));
            links.put(2,new Link("facebook.com","1234"));
            links.put(3,new Link("ole.com.ar","1234"));
            links.put(4,new Link("mercadolibre.com","1234"));
            links.put(5,new Link("mercadopago.com","1234"));
    }
    public Map<Integer, Link> getLinks(){
        return links;
    }
    public Integer createLink{
        Integer id = links.size();
        links.put(id,link());

    }
}
