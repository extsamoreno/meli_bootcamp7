package com.example.LinkTracker.repositories;

import com.example.LinkTracker.models.Link;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class LinkRepository implements ILinkRepository{
    private static Map<Integer, Link> links = new HashMap<>();
    static {
            links.put(0,new Link("http://google.com","1234"));
            links.put(1,new Link("http://google.com","1234"));
            links.put(2,new Link("http://facebook.com","1234"));
            links.put(3,new Link("http://ole.com.ar","1234"));
            links.put(4,new Link("http://mercadolibre.com","1234"));
            links.put(5,new Link("http://mercadopago.com","1234"));
    }

    public Map<Integer, Link> getLinks(){
        return links;
    }
    public Integer createLink(Link link){
        Integer id = links.size();
        links.put(id,link);
        return id;
    }
}
