package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository {

    private static HashMap<Integer, Link> links = new HashMap<>() {{
        put(1, new Link(1, "https://www.youtube.com", "123", 0));
        put(2, new Link(2, "https://www.google.com", "123", 0));
        put(3, new Link(3, "https://www.spotify.com", "123", 0));
    }};

    private static Integer index = 3;


    @Override
    public Link createLink(LinkRequestDTO linkRequestDTO) {
        index++;

        Link newLink = new Link(index, linkRequestDTO.getUrl(), linkRequestDTO.getPassword(), 0);
        links.put(index, newLink);

        return newLink;
    }

    @Override
    public Link findById(Integer id) {
        //links.containsKey(id);
        return links.getOrDefault(id, null);
    }

    @Override
    public Link deleteLink(Integer id) {
        return links.remove(id);
    }
}
