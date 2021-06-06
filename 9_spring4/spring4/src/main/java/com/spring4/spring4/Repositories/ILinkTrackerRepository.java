package com.spring4.spring4.Repositories;

import com.spring4.spring4.Exceptions.LinkNotFoundException;
import com.spring4.spring4.Models.Link;

public interface ILinkTrackerRepository {
    Link create(Link link);
    Link getLink(int id) throws LinkNotFoundException;
    void addRedirectionCont(Link link);
    void invalidate(int id);
}
