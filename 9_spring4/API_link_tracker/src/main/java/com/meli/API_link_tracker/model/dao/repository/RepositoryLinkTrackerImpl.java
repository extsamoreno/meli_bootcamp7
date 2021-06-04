package com.meli.API_link_tracker.model.dao.repository;

import com.meli.API_link_tracker.database.DataBaseLinkTracker;
import com.meli.API_link_tracker.model.dao.model.Link;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Repository
public class RepositoryLinkTrackerImpl implements RepositoryLinkTracker{

    private HashMap<Integer, Link> getDataBase() {
        return DataBaseLinkTracker.dataBase;
    }

    public Link getLinkOfDataBaseAt(int linkID) {
        Link link;
        HashMap<Integer, Link> database = getDataBase();
        Set<Integer> keys = database.keySet();
        if(keys.contains(linkID)) {
            link = database.get(linkID);
        } else {
            return null;
        }
        return link;
    }

    public int addLinkToDataBase(Link link) {
        HashMap<Integer, Link> database = getDataBase();
        int size = database.size() + 1;
        database.put(size, link);
        return size;
    }

    public boolean verificateExistOfValue(String linkToVerify) {
        Collection<Link> links = getDataBase().values();
        for (Link link: links) {
            if(link.getLink().equals(linkToVerify)) {
                return true;
            }
        }
        return false;
    }
}
