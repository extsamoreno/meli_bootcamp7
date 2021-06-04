package com.meli.API_link_tracker.model.mapper;

import com.meli.API_link_tracker.model.dao.model.Link;
import com.meli.API_link_tracker.model.dto.*;
import org.springframework.stereotype.Component;

@Component
public class LinkTrackerMapper {
    public static Link convertToDomain(LinkRequest linkRequest, String password) {
        Link newLink = new Link();
        newLink.setLink(linkRequest.getLink());
        newLink.setPassword(password);
        return newLink;
    }

    public static LinkRespond convertToLinkRespond (int idLink) {
        LinkRespond linkRespond = new LinkRespond();
        String linkTracked = "http://localhost:8087/meli/api/link_tracker/v1/link/" + idLink;
        linkRespond.setLinkTracked(linkTracked);
        return linkRespond;
    }
}
