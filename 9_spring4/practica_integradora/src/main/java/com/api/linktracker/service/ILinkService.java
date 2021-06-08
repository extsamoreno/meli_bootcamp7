package com.api.linktracker.service;

import com.api.linktracker.dto.LinkRequestDTO;
import com.api.linktracker.dto.LinkResponseDTO;
import com.api.linktracker.exception.IncorrectIdException;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkService {

    LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO);

    String invalidateLink(int linkId) throws IncorrectIdException;

    String revalidateLink(int linkId) throws IncorrectIdException;

    boolean isValidLinkId(int linkId);

    boolean linkNotExists(int linkId);

    RedirectView redirectLink (int linkId);

    boolean isValidPassword(int linkId, String password);

    int getRedirectionCounter(int linkId);
}
