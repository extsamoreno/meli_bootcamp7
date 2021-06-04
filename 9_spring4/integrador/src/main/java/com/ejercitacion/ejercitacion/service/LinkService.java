package com.ejercitacion.ejercitacion.service;

import com.ejercitacion.ejercitacion.dto.LinkIdResponse;
import com.ejercitacion.ejercitacion.dto.LinkRedirectionStadisticsResponse;
import com.ejercitacion.ejercitacion.dto.StoreLinkRequest;
import com.ejercitacion.ejercitacion.exception.InvalidLinkPasswordException;
import com.ejercitacion.ejercitacion.exception.LinkException;
import com.ejercitacion.ejercitacion.exception.LinkIdNotFoundException;

public interface LinkService {

    LinkIdResponse storeNewLink(StoreLinkRequest request) throws LinkException;
    String getRequestedLinkForRedirection(Integer id, String password) throws LinkException;
    LinkRedirectionStadisticsResponse getRedirectionsStadistics(Integer id) throws LinkIdNotFoundException;
    void invalidateLink(Integer id) throws LinkIdNotFoundException;
}
