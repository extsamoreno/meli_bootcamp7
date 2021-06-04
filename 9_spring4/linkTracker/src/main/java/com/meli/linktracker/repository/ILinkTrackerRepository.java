package com.meli.linktracker.repository;

import com.meli.linktracker.domain.Link;
import com.meli.linktracker.exception.IdNotFoundException;

public interface ILinkTrackerRepository {

    Integer save(Link newLink);

    Link getLinkByID(Integer linkId) throws IdNotFoundException;

    void addRedirect(Integer linkId) throws IdNotFoundException;

    void invalidateByLinkId(Integer linkId) throws IdNotFoundException;
}
