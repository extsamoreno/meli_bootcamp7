package com.ejercitacion.ejercitacion.repository;

import com.ejercitacion.ejercitacion.entity.StoredLink;
import com.ejercitacion.ejercitacion.exception.LinkIdNotFoundException;

public interface LinkRepository {

    StoredLink storeNewLink(StoredLink storedLink);
    StoredLink getStoredLinkById(Integer id);
    boolean incrementRedirectionCounterById(Integer id) throws LinkIdNotFoundException;
    boolean invalidateLinkById(Integer id);
}
