package com.meli.spring.repository;

import com.meli.spring.models.Link;

public interface LinkRepository {
    void save(Link link);
    void update(Link link);
    Link findByLinkID(String linkID);
    void incrementVisitCounter(Link link);
}
