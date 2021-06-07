package com.example.project_url.repository;

import com.example.project_url.models.Link;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class LinkRepository implements ILinkRepository {
    private Map<Integer, Link> links;

    public LinkRepository() {
        this.links = new HashMap<Integer, Link>();
    }

    @Override
    public Link create(Link link) {
        int newId = this.links.size() + 1;
        link.setId(newId);
        links.put(newId, link);
        return link;
    }

    @Override
    public Link getById(int linkId) {
        return links.get(linkId);
    }

    @Override
    public void invalidate(Link link) {
        link.setActive(false);
    }

    @Override
    public Link getByUrl(String url) {
        Link linkRetorno = null;

        //Iterator for links
        Iterator<Map.Entry<Integer, Link>> it = links.entrySet().iterator();
        while (it.hasNext() && linkRetorno == null) {
            Map.Entry<Integer, Link> pair = it.next();
            if (pair.getValue().getUrl().equalsIgnoreCase(url)) {
                linkRetorno = pair.getValue();
            }
        }

        return linkRetorno;
    }
}
