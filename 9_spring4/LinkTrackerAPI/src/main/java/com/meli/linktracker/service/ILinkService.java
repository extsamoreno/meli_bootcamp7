package com.meli.linktracker.service;

import com.meli.linktracker.exception.FormatLinkException;
import com.meli.linktracker.exception.InvalidCredentialsException;
import com.meli.linktracker.exception.InvalidatedLinkException;
import com.meli.linktracker.exception.LinkNotFoundException;
import com.meli.linktracker.service.dto.LinkDTORequest;
import com.meli.linktracker.service.dto.
        LinkDTOResponse;

import javax.servlet.http.HttpServletResponse;

public interface ILinkService {
    public LinkDTOResponse maskUrl(LinkDTORequest link) throws FormatLinkException;
    public void redirectUrl(int linkId, String password, HttpServletResponse response) throws InvalidCredentialsException, LinkNotFoundException, InvalidatedLinkException;
    public int getStatistics(int linkId) throws LinkNotFoundException;
    public String invalidate(int linkId, String password) throws LinkNotFoundException, InvalidatedLinkException, InvalidCredentialsException;
}
