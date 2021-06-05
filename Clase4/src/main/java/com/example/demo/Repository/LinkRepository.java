package com.example.demo.Repository;

import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class LinkRepository implements ILinkRepository{

    static ArrayList<Link> dataLinks = new ArrayList<>();

    @Override
    public void addLink(Link link) {
        dataLinks.add(link);
    }

    @Override
    public int getArraySize() {
        return dataLinks.size();
    }

    @Override
    public Link getLinkByID(int id) throws LinkIdNotFoundException {
        Link link = new Link();
        try {
             link = dataLinks.get(id);
        }catch (Exception e){
            throw new LinkIdNotFoundException(id);
        }
        return link;
    }


}
