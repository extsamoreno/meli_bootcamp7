package com.example.demo.Repository;

import com.example.demo.Exception.DuplicatedLinkException;
import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Exception.InvaidLinkException;
import com.example.demo.Model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class LinkRepository implements ILinkRepository{

    static ArrayList<Link> dataLinks = new ArrayList<>();


    @Override
    public boolean checkduplicated(String getlink) {
        return dataLinks.stream().anyMatch(link -> link.getLink().equals(getlink));
    }

    @Override
    public void addLink(Link link) throws DuplicatedLinkException {
        if(checkduplicated(link.getLink())){
            throw new DuplicatedLinkException(link.getLink());
        }
        dataLinks.add(link);
    }

    @Override
    public int getArraySize() {
        return dataLinks.size();
    }


    @Override
    public Link getLinkByID(int id) throws LinkIdNotFoundException,InvaidLinkException {
        Link link = new Link();
        try {
            link = dataLinks.get(id);

        } catch (Exception e) {
            throw new LinkIdNotFoundException(id);
        }

        if (!link.isStatus()) {
            throw new InvaidLinkException(id);
        }
        return link;

    }

}
