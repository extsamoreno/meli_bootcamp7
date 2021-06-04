package com.meli.linktracker.ejercicioSpring.repository;

import com.meli.linktracker.ejercicioSpring.model.Link;

import java.util.List;

public interface ILinkRepository {
    public List<Link> saveLink(Link link);
    public List<Link> showLink();
    public void setView(Link link, int view);
    public int getView(int linkid);
}
