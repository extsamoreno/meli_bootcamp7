package com.linkTracker;

import com.exceptions.InvalidUrlException;
import com.models.LinkDTO;
import com.models.UrlDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public interface iLinkTrackerService {

    UrlDTO createLink (String url) throws InvalidUrlException;
    UrlDTO createLink (String url, String password);
    LinkDTO redirect (Integer linkId);
    LinkDTO redirect (Integer linkId, String password);
    Integer calculateRedirectionMetrics (Integer linkId);
    LinkDTO invalidateLink (Integer linkId);
}
