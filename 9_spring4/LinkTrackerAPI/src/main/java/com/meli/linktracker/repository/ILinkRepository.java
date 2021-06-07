package com.meli.linktracker.repository;

import com.meli.linktracker.model.Link;

public interface ILinkRepository {
    public Link getLinkById(int id);
    public void saveLink(Link link);
}
