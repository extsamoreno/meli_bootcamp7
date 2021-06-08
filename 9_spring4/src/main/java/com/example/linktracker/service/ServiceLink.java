package com.example.linktracker.service;

import com.example.linktracker.exception.LinkIncorrectPasswordException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.exception.LinkUnavailableException;
import com.example.linktracker.model.Link;
import com.example.linktracker.repository.iLinkRepository;
import com.example.linktracker.service.dto.LinkDTO;
import com.example.linktracker.service.dto.ResponseLinkDTO;
import com.example.linktracker.service.mapper.LinkMapper;
import com.example.linktracker.service.mapper.LinkResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class ServiceLink implements iServiceLink {

    @Autowired
    iLinkRepository iLinkRepo;

    @Override
    public ResponseLinkDTO createLink(LinkDTO link) {
        Link newLink = LinkMapper.toLink(link);
        newLink.setActive(true);
        newLink = iLinkRepo.saveLink(newLink);

        return LinkResponseMapper.toLinkDTO(newLink);
    }

    @Override
    public String redirectByLinkID(Integer linkID, String password) throws LinkNotFoundException, LinkUnavailableException, LinkIncorrectPasswordException {

        Link storedLink = iLinkRepo.findLinkByID(linkID);

        // Exception: Link doesnt exist
        if (storedLink == null) {
            throw new LinkNotFoundException(linkID);
        }

        // Exception: Link Unavailable
        if(!storedLink.isActive()){
            throw new LinkUnavailableException(linkID);
        }

        // Exception: Incorrect Password
        if(!storedLink.getPassword().equals(password)){
            throw new LinkIncorrectPasswordException();
        }

        // Update metrics link
        storedLink.setConsultTimes(storedLink.getConsultTimes()+1);
        iLinkRepo.saveLink(storedLink);

        return storedLink.getUrl();
    }

    @Override
    public ResponseLinkDTO getMetricsbyLinkID(Integer linkID) throws LinkNotFoundException {

        Link storedLink = iLinkRepo.findLinkByID(linkID);

        if (storedLink == null) {
            throw new LinkNotFoundException(linkID);
        }

        return LinkResponseMapper.toLinkDTO(storedLink);
    }

    @Override
    public ResponseLinkDTO invalidateLink(Integer linkID) throws LinkNotFoundException {

        Link storedLink = iLinkRepo.findLinkByID(linkID);

        if (storedLink == null) {
            throw new LinkNotFoundException(linkID);
        }

        storedLink.setActive(false);
        iLinkRepo.saveLink(storedLink);

        return LinkResponseMapper.toLinkDTO(storedLink);
    }
}
