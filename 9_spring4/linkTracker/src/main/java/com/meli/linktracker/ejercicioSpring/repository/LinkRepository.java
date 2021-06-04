package com.meli.linktracker.ejercicioSpring.repository;

import com.meli.linktracker.ejercicioSpring.model.Link;
import com.meli.linktracker.ejercicioSpring.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    @Autowired
    LinkService linkService;
    List<Link> listaLinks = new ArrayList<>();
    @Override

    public List<Link> saveLink(Link link) {

        listaLinks.add(link);
        return listaLinks;
    }

    public List<Link> showLink() {
        return listaLinks;
    }

    @Override
    public void setView(Link link, int view) {
        link.setViews(view);

    }

    @Override
    public int getView(int linkid) {
        return linkService.getLinkById(linkid).getViews();
    }

}
