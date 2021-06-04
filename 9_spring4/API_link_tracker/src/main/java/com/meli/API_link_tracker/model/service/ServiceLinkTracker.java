package com.meli.API_link_tracker.model.service;

import com.meli.API_link_tracker.model.dto.LinkRequest;
import com.meli.API_link_tracker.model.dto.LinkRespond;

public interface ServiceLinkTracker {
    LinkRespond createLinktoDataBase(LinkRequest linkRequest, String password);
    public String getLinkRedired(int id);
}
