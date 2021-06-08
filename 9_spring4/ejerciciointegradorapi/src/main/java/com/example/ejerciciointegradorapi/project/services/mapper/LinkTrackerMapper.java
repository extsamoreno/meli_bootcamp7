package com.example.ejerciciointegradorapi.project.services.mapper;

import com.example.ejerciciointegradorapi.project.Dao.models.LinkTracker;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerMetricsDTO;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerResponseDTO;

public class LinkTrackerMapper {
    public static LinkTrackerResponseDTO toDTO (LinkTracker linkTracker){
        return new LinkTrackerResponseDTO(linkTracker.getLinkId(),linkTracker.getUrl());
    }

    public static LinkTrackerMetricsDTO metricsToDTO (LinkTracker linkTracker){
        return new LinkTrackerMetricsDTO(linkTracker.getRedirectCounter());
    }
}
