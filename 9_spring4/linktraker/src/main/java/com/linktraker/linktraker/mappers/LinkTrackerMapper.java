package com.linktraker.linktraker.mappers;

import com.linktraker.linktraker.models.LinkTracker;
import com.linktraker.linktraker.services.dtos.LinkDTO;
import com.linktraker.linktraker.services.dtos.LinkTrackerDTO;

public class LinkTrackerMapper {

    public static LinkTracker mapDtoToModel(LinkTrackerDTO linkTrackerDTO) {
        LinkTracker linkTracker = new LinkTracker();

        linkTracker.setUrl(linkTrackerDTO.getUrl());
        linkTracker.setPassword(linkTrackerDTO.getPassword());

        return linkTracker;
    }

    public static LinkDTO mapModelToDto(LinkTracker linkTracker) {
        return new LinkDTO(linkTracker.getId(), linkTracker.getUrl(), linkTracker.getRedirections(), linkTracker.isEnable());
    }
}
