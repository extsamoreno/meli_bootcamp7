package com.meli.spring.services;

import com.meli.spring.exceptions.LinkIDNotFoundException;
import com.meli.spring.exceptions.LinkUnauthorizedException;
import com.meli.spring.services.dto.LinkDto;

public interface LinkService {
    LinkDto findlink(String linkID) throws LinkIDNotFoundException;
    LinkDto saveLink(String url, String pass);
    Integer getMetrics(String linkID) throws LinkIDNotFoundException;
    String invalidateLink(String linkID, String pass) throws LinkUnauthorizedException;
}
