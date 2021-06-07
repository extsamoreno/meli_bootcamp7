package com.linktracker.demo.repositories;

import com.linktracker.demo.exceptions.LinkNotFoundException;
import com.linktracker.demo.models.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer,Link> linkHashMap = new HashMap<>();
    private HashMap<Integer, Integer> countLinksRedirect = new HashMap<>();

    @Override
    public Link addLink(Link link) {

        int id = linkHashMap.size() + 1;
        linkHashMap.put(id, new Link(link.getUrl(), true, link.getPassword()));
        link.setId(linkHashMap.size());

        countLinksRedirect.put(id, 0);

        return link;
    }

    @Override
    public Link findLinkByUrl(String url) {
        Link link = null;
        for (Map.Entry<Integer, Link> entry: linkHashMap.entrySet()) {
            String entryUrl = entry.getValue().getUrl();

            if(entryUrl.equals(url)){
                link = new Link(entry.getKey(), entry.getValue().getUrl(), entry.getValue().isValid(), link.getPassword());
            }
        }

        return link;
    }

    @Override
    public Link findLinkById(Integer id, String password) {
        Link link = null;
        for (Map.Entry<Integer, Link> entry: linkHashMap.entrySet()) {
            int entryId = entry.getKey();
            String entryPassword = entry.getValue().getPassword();
            if(entryId == id && entryPassword.equals(password)){
                link = new Link(entry.getKey(), entry.getValue().getUrl(), entry.getValue().isValid());
            }
        }

        return link;
    }

    @Override
    public void addLinkCounter(Integer id){
        Integer count = countLinksRedirect.get(id) + 1;
        countLinksRedirect.put(id, count++);
    }

    @Override
    public Integer getLinkCounter(Integer id) throws LinkNotFoundException {
        Integer counter = null;
        counter = countLinksRedirect.get(id);
        return counter;
    }

    @Override
    public Link invalidateLinkByUrl(Integer id) throws LinkNotFoundException {
        Link link = null;
        link = linkHashMap.get(id);
        link.setValid(false);
        linkHashMap.put(id, link);

        return link;
    }
}
