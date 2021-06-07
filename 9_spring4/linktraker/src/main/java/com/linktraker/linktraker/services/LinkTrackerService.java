package com.linktraker.linktraker.services;

import com.linktraker.linktraker.exceptions.*;
import com.linktraker.linktraker.mappers.LinkTrackerMapper;
import com.linktraker.linktraker.models.LinkTracker;
import com.linktraker.linktraker.repositories.ILinkTrackerRepository;
import com.linktraker.linktraker.services.dtos.LinkDTO;
import com.linktraker.linktraker.services.dtos.LinkTrackerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class LinkTrackerService implements ILinkTrackerService {

    @Autowired
    private ILinkTrackerRepository trackerRepository;

    @Override
    public LinkDTO createLink(LinkTrackerDTO linkTrackerDTO) throws LinkNotExistException {
        LinkTracker linkModel = LinkTrackerMapper.mapDtoToModel(linkTrackerDTO);

        if (!isValidURL(linkModel)) throw new LinkNotExistException(linkModel.getUrl());

        linkModel.setEnable(true);

        int id = trackerRepository.createLink(linkModel);

        return new LinkDTO(id, "http://localhost:8080/" + id, 0, true);
    }

    private boolean isValidURL(LinkTracker linkTracker) {
        try {
            new URL(linkTracker.getUrl()).toURI();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String redirectById(int idLink, String password) throws IncorrectPasswordException, DisableException, LinkIdNotFoundException {
        LinkTracker linkTracker = trackerRepository.getLinkById(idLink);

        if (linkTracker == null) throw new LinkIdNotFoundException(idLink);

        if (!linkTracker.getPassword().equals(password)) throw new IncorrectPasswordException();

        if (!linkTracker.isEnable()) throw new DisableException();

        linkTracker.setRedirections(linkTracker.getRedirections() + 1);

        trackerRepository.updateLink(linkTracker);

        return linkTracker.getUrl();
    }

    @Override
    public LinkDTO statsLinksById(int idLink) throws LinkIdNotFoundException {
        LinkTracker linkTracker = trackerRepository.getLinkById(idLink);

        if (linkTracker == null) throw new LinkIdNotFoundException(idLink);

        LinkDTO result = LinkTrackerMapper.mapModelToDto(linkTracker);

        return result;
    }

    @Override
    public LinkDTO invalidateLink(int idLink) throws LinkIdNotFoundException {
        LinkTracker linkTracker = trackerRepository.getLinkById(idLink);

        if (linkTracker == null) throw new LinkIdNotFoundException(idLink);

        linkTracker.setEnable(false);

        LinkDTO result = LinkTrackerMapper.mapModelToDto(linkTracker);

        return result;
    }
}
