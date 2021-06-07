package com.meli.linktracker.repository;

import com.meli.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class LinkRepositoryImp implements ILinkRepository {

    Map<Integer, Link> database;

    public LinkRepositoryImp() {
        this.database = new HashMap<>();
    }

    @Override
    public Link save(Link link) {
        Link searchedLink = findByUrl(link.getUrl());
        if (searchedLink == null) {
            link.setId(database.size() + 1);
            link.setNumRedirections(0);
            database.put(database.size() + 1, link);
            return link;
        }
        return searchedLink;
    }

    @Override
    public Link findById(Integer id) {
        return database.get(id);
    }

    @Override
    public Link findByUrl(String url) {
        database.entrySet().stream().filter(e -> e.getValue().getUrl().compareTo(url) == 0);
        for (Map.Entry<Integer, Link> entry : database.entrySet()) {
            if (entry.getValue().getUrl().compareTo(url) == 0) {
                return database.get(entry.getKey());
            }
        }
        return null;
    }

    @Override
    public void updateLink(Link link) {
        database.put(link.getId(), link);
    }
}
