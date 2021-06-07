package com.meli.linktracker.service;

import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.LinkResponseDto;
import com.meli.linktracker.service.dto.MetricsDTO;

public interface ILinkService {

    LinkResponseDto createLink(LinkDTO link);

    LinkDTO getUrlById(Integer id);

    MetricsDTO getMetricsByLinkId(Integer id);

    LinkResponseDto invalidateLinkById(Integer id);

}
