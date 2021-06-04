package com.meli.linktracker.repository;

import com.meli.linktracker.domain.Link;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private List<Link> list = new ArrayList();
    private Integer cont = 0;

    @Override
    public Integer create(URI newURI) {
        Link link = new Link(cont, newURI);
        list.add(link);
        cont++;
        return link.getId();
    }

    @Override
    public URI getURIByID(Integer linkId) {

        Optional<Link> link = list.stream().filter(l -> l.getId() == linkId && l.isValid()).findFirst();

        if (link.isPresent()) {
            return link.get().getUri();
        } else {
            return null;
        }

    }
}
