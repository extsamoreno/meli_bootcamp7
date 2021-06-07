package com.api.apiMask.repository.implementation;

import com.api.apiMask.exception.LinkDontExistException;
import com.api.apiMask.exception.URLAlreadyUsedException;
import com.api.apiMask.repository.contract.ILinkRepository;
import com.api.apiMask.repository.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private final List<Link> links = new ArrayList<>();

    @Override
    public Link createLink(String url, String password) throws URLAlreadyUsedException{
        checkURL(url);
        Link newLink = new Link(url, password);
        var lastId = links.isEmpty() ? 0 : getLastID();
        newLink.setLinkId(lastId+1);
        links.add(newLink);
        return newLink;
    }

    @Override
    public Link getByLinkId(long linkId) throws LinkDontExistException {
        Optional<Link> link = links.stream().filter(x -> x.getLinkId() == linkId).findFirst();
        if (link.isEmpty())
            throw new LinkDontExistException(linkId);
        else
            return link.get();
    }

    @Override
    public void save(Link link) throws LinkDontExistException {
        var linkDB = getByLinkId(link.getLinkId());
        linkDB.setAll(link);
    }

    private Long getLastID() {
        return links.get(links.size()-1).getLinkId();
    }

    private void checkURL(String url) throws URLAlreadyUsedException {
        var isUsed = links.stream().anyMatch(x -> x.getUrl().equals(url));
        if (isUsed)
            throw new URLAlreadyUsedException(url);
    }
}
