package com.meli.linktracker.repository;

import java.net.URI;

public interface ILinkTrackerRepository {
    Integer create(URI newURI);

    URI getURIByID(Integer linkId);

}
