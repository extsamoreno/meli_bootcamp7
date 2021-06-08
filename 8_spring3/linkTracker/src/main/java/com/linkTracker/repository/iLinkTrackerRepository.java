package com.linkTracker.repository;

import com.models.LinkDTO;
import com.models.UrlDTO;

public interface iLinkTrackerRepository {

    UrlDTO saveLink (String url);
    LinkDTO getLinkDto (Integer linkId);
    UrlDTO saveLink(String url, String password);

}
