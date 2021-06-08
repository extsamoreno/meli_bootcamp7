package com.example.demo.repository;

import com.example.demo.exceptions.LinkInvalidPasswordOrIdException;
import com.example.demo.exceptions.LinkNotFoundException;
import com.example.demo.models.Link;
import com.example.demo.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImple implements LinkRepository{


    @Autowired
    LinkService linkService;

    private List<Link> linkList = new ArrayList<>();
    private int counter=0;
    private int idLink=0;

    @Override
    public Link addLink(Link link) {
        link.setId(++idLink);
        linkList.add(link);

        return link;
    }

    @Override
    public Link findLinkByAddress(String address) {
        Link linkR = null;
        for(Link link:linkList){
            if(link.getAddress().equals(address)){
                linkR = link;
                break;
            }
        }
        return linkR;
    }


    @Override
    public Link findLinkById(int id, String password) throws LinkInvalidPasswordOrIdException {
        Link linkR = null;
        for(Link link:linkList){
            if( link.getId() == id && link.getPassword().equals(password)){
                linkR = link;
            }
        }

        if(linkR == null){
            throw new LinkInvalidPasswordOrIdException();
        }
        return linkR;
    }

    @Override
    public void addLinkCounter(int id) throws LinkNotFoundException {
        try{
            for(Link link:linkList){
                if(link.getId() == id){
                    link.setCount(link.getCount()+1);
                }
            }
        }
        catch(NullPointerException ex){
            throw new LinkNotFoundException(id);
        }
    }

    @Override
    public int getLinkCounter(int id) throws LinkNotFoundException {
        int counter=-1;

        for(Link link:linkList){
            if(link.getId() == id){
                counter = link.getCount();
            }
        }

        if(counter == -1){
            throw new LinkNotFoundException(id);
        }

        return counter;
    }

    @Override
    public Link invalidateLinkByAddress(Integer id) throws LinkNotFoundException {
        Link linkR = null;
        try{
            for(Link link:linkList){
                if(link.getId() == id){
                    link.setValid(false);
                    linkR = link;
                }
            }
        }catch (NullPointerException ex){
            throw new LinkNotFoundException(id);
        }

        return linkR;
    }

    @Override
    public Link validateLinkByAddress(Integer id) throws LinkNotFoundException {
        Link linkR = null;
        try{
            for(Link link:linkList){
                if(link.getId() == id){
                    link.setValid(true);
                    linkR = link;
                }
            }
        }catch (NullPointerException ex){
            throw new LinkNotFoundException(id);
        }

        return linkR;
    }
}
