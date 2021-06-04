package com.meli.linktracker.repository;

import com.meli.linktracker.domain.Link;
import com.meli.linktracker.exception.IdNotFoundException;

import java.net.URI;

public interface ILinkTrackerRepository {

    Integer save(URI newURI);

    Link getLinkByID(Integer linkId) throws IdNotFoundException;

    void addRedirect(Integer linkId) throws IdNotFoundException;

    void invalidateByLinkId(Integer linkId) throws IdNotFoundException;
}
