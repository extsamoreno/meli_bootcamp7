package com.meli.linkTracker.service;

import com.meli.linkTracker.dto.UrlDto;
import com.meli.linkTracker.dto.UrlInputDto;
import com.meli.linkTracker.exception.InvalidFormatUrlException;
import com.meli.linkTracker.exception.UrlException;
import org.springframework.web.servlet.view.RedirectView;

public interface IUrlService {
    public String addUrl (UrlInputDto newUrl) throws InvalidFormatUrlException;

    RedirectView redirect(String linkId, String password) throws UrlException;

    UrlDto metrics(String linkId) throws UrlException;

    void disable(String linkId) throws UrlException;
}
