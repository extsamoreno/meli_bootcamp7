package com.meli.API_link_tracker.model.service;

import com.meli.API_link_tracker.model.dao.model.Link;
import com.meli.API_link_tracker.model.dao.repository.RepositoryLinkTracker;
import com.meli.API_link_tracker.model.dto.LinkRequest;
import com.meli.API_link_tracker.model.dto.LinkRespond;
import com.meli.API_link_tracker.model.mapper.LinkTrackerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLinkTrackerImpl implements ServiceLinkTracker{
    @Autowired
    private RepositoryLinkTracker repositoryLinkTracker;

    public LinkRespond createLinktoDataBase(LinkRequest linkRequest, String password) {
        Link newLink = LinkTrackerMapper.convertToDomain(linkRequest, password);
        int idLink = repositoryLinkTracker.addLinkToDataBase(newLink);
        LinkRespond linkRespond = LinkTrackerMapper.convertToLinkRespond(idLink);
        return linkRespond;
    }

    public String getLinkRedired(int id) {
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(id);
        link.increaseTimesUsed();
        return link.getLink();
    }
}
