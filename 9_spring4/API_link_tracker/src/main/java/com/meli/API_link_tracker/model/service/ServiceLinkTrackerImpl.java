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

    public String getLinkRedired(int linkId) {
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(linkId);
        link.increaseTimesUsed();
        return link.getLink();
    }

    public int getMetricsOfLink(int linkId) {
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(linkId);
        return link.getTimeUsed();
    }

    public boolean invalidateLink(int linkId) {
        Link link = repositoryLinkTracker.getLinkOfDataBaseAt(linkId);
        link.setValid(false);
        return true;
    }
}
