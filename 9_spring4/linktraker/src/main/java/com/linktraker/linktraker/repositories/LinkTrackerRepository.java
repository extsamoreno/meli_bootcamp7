package com.linktraker.linktraker.repositories;

import com.linktraker.linktraker.models.LinkTracker;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {

    private HashMap<Integer, LinkTracker> database;

    public LinkTrackerRepository() {
        this.database = new HashMap<>();
    }

    @Override
    public int createLink(LinkTracker linkTracker) {
        int idValue = database.size() + 1;

        database.put(idValue, linkTracker);

        return idValue;
    }

    @Override
    public LinkTracker getLinkById(int idLink) {
        return database.get(idLink);
    }

    @Override
    public int updateLink(LinkTracker linkTracker) {
        database.put(linkTracker.getId(), linkTracker);

        return linkTracker.getId();
    }
}
