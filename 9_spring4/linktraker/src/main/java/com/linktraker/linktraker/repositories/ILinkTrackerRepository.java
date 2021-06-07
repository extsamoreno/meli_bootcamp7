package com.linktraker.linktraker.repositories;

import com.linktraker.linktraker.models.LinkTracker;

public interface ILinkTrackerRepository {
    int createLink(LinkTracker linkTracker);
    LinkTracker getLinkById(int idLink);
    int updateLink(LinkTracker linkTracker);
}
