package com.api.linktracker.service;

import com.api.linktracker.dto.LinkRequestDTO;
import com.api.linktracker.dto.LinkResponseDTO;
import com.api.linktracker.exception.IncorrectIdException;
import com.api.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    public LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) {

        String password = linkRequestDTO.getPassword();

        int linkId;

        if (password != null) {
            linkId = linkRepository.createLink(linkRequestDTO.getUrl(), password);
        } else {
            linkId = linkRepository.createLink(linkRequestDTO.getUrl());
        }
        return new LinkResponseDTO(linkId);
    }

    public String invalidateLink(int linkId) throws IncorrectIdException {

        linkRepository.setLinkValidation(linkId, false);
        return "Success: The link has been successfully invalidated";
    }

    @Override
    public String revalidateLink(int linkId) throws IncorrectIdException {

        linkRepository.setLinkValidation(linkId, true);
        return "Success: The link has been successfully revalidated";
    }

    public boolean isValidLinkId(int linkId) {
        return linkRepository.isLinkIdValid(linkId);
    }

    public boolean linkNotExists(int linkId) {
        return !linkRepository.linkIdExists(linkId);
    }

    public RedirectView redirectLink(int linkId) {

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(linkRepository.getLinkURLById(linkId));

        linkRepository.increaseRedirectionCounter(linkId);

        return redirectView;
    }

    public boolean isValidPassword(int linkId, String password) {

        if (linkRepository.getPasswordById(linkId) != null) {
            return linkRepository.getPasswordById(linkId).equals(password);
        } else {
            return password == null;
        }
    }

    @Override
    public int getRedirectionCounter(int linkId) {
        return linkRepository.getRedirectionCounterById(linkId);
    }
}
