package com.meli.spring.repository;

import com.meli.spring.models.Link;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    List<Link> linkList = new ArrayList<>();

    @Override
    public void save(Link link) {
            this.linkList.add(link);
    }

    @Override
    public void update(Link link) {
        for(Link item : linkList){
            if(item.getLinkID().equals(link.getLinkID())){
                item.setLinkID(link.getLinkID());
                item.setPassword(link.getPassword());
                item.setUrl(link.getUrl());
                item.setContVisits(link.getContVisits());
                break;
            }
        }
    }

    @Override
    public Link findByLinkID(String linkID){
        Optional<Link> linkExist = this.linkList.stream().filter(link -> link.getLinkID().equals(linkID)).findFirst();

        if(linkExist.isPresent()){
           return linkExist.get();
        }

        return null;
    }

    @Override
    public void incrementVisitCounter(Link link) {
        this.linkList.stream().forEach(link1 -> {
            if(link1.getLinkID().equals(link.getLinkID())){
                int incrementTotal = link1.getContVisits();
                link1.setContVisits(++incrementTotal);
            }
        });
    }


}
