package com.spring.spring4.Repository;

import com.spring.spring4.Classes.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {

    List<Link> linkList = new ArrayList<>();

    @Override
    public Link saveLink(String url, String password) {
        Link link = new Link();
        link.setId(linkList.size());
        link.setUrl(url);
        link.setPassword(password);
        linkList.add(link);
        return link;
    }

    @Override
    public List<Link> getLinks() {
        return linkList;
    }
}
