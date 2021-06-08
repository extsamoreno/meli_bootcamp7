package com.meli.linktracker.repository;

import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.model.Link;

public interface ILinkTrackerRepository {
    Integer save(Link newLink);
    Link getLinkByID(Integer linkId) throws IdNotFoundException;
    void addRedirect(Integer linkId) throws IdNotFoundException;
    void invalidateByLinkId(Integer linkId) throws IdNotFoundException;
}
