package com.example.demo.repositories;

import com.example.demo.models.Link;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    private List<Link> links = new ArrayList<>();
    private int numberOfLinks = 0;

    @Override
    public int add(Link link) {
        numberOfLinks = links.size() + 1;
        link.setID(numberOfLinks);
        links.add(link);

        System.out.println(links.toString());
        return numberOfLinks;
    }


    @Override
    public Link getLinkById(int id) {

        Link link = new Link();
        link.setID(-1);

        for(Link l:links){
            if( l.getID() == id){
                link =l;
                break;
            }
        }

        return link ;
    }

    @Override
    public void increaseCount(int id) {

        for(Link l:links){
            if( l.getID() == id){
                l.increaseCount();
            }
        }

    }

    @Override
    public void deactiveById(int id) {

        for(Link l:links){
            if( l.getID() == id){
                l.deactivate();
            }
        }
    }

}
