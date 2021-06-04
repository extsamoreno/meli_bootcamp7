package com.meli.API_link_tracker.model.dao.repository;

import com.meli.API_link_tracker.model.dao.model.Link;

public interface RepositoryLinkTracker {
    Link getLinkOfDataBaseAt(int linkID);
    int addLinkToDataBase(Link link);
    public boolean verificateExistOfValue(String linkToVerify);
}
