package com.spring4.ejercicios.link.repository;

import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    private HashMap<Integer, Link> linksDB = new HashMap<>();

    @Override
    public void insertNewLink(Link link) {
        linksDB.put(link.getLinkId(), link);
    }

    @Override
    public Link getLinkById(Integer id) throws IdNotFoundException {
        if (linksDB.containsKey(id))
            return linksDB.get(id);
        else
            throw new IdNotFoundException(id);
    }

    @Override
    public void updateValidLink(Integer id) throws IdNotFoundException {
        Link linkToUpdate = getLinkById(id);
        linkToUpdate.setLinkValid(false);
        linksDB.replace(id,linkToUpdate);
    }

    @Override
    public void updateViewsLink(Integer id, Integer views) throws IdNotFoundException {
        Link linkToUpdate = getLinkById(id);
        linkToUpdate.setLinkViews(views);
        linksDB.replace(id,linkToUpdate);
    }


}
