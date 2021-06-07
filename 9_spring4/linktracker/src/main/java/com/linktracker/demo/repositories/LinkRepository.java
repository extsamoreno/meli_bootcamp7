package com.linktracker.demo.repositories;

import com.linktracker.demo.exceptions.LinkIDNotValidException;
import com.linktracker.demo.models.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer,Link> linksHm = new HashMap<>();

    @Override
    public Link addLink(Link link) {

        linksHm.put(linksHm.size() + 1, link);

        link.setId(linksHm.size());

        return link;
    }

    @Override
    public Link findLinkByUrl(String url) {
        Link link = null;
        for (Map.Entry<Integer, Link> entry: linksHm.entrySet()) {
            String entryUrl = entry.getValue().getUrl();

            if(entryUrl.equals(url)){
                link = entry.getValue();
            }
        }

        return link;
    }

    @Override
    public Link findLinkByID(int id) {
        return linksHm.get(id);
    }

    @Override
    public int getLinkReport(int id) {
        return linksHm.get(id).getRequestCount();
    }

    @Override
    public void incrementLinkReport(int id) {
        linksHm.get(id).setRequestCount(linksHm.get(id).getRequestCount() + 1);
    }

    @Override
    public boolean invalidateLink(int id){
        try {
            linksHm.get(id).setActive(false);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean isLinkActive(int id){
        return linksHm.get(id).isActive();
    }

    @Override
    public void log(){
        System.out.println("- - lINK LIST - -");
        System.out.println();
        linksHm.forEach((k,v) -> {
            System.out.println("ID: " + v.getId());
            System.out.println("URL: " + v.getUrl());
            System.out.println("Request count: " + v.getRequestCount());
            System.out.println("Is active: " + v.isActive());
            System.out.println();
        });

    }


}
