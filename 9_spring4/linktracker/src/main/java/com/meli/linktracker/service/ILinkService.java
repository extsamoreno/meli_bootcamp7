package com.meli.linktracker.service;

import com.meli.linktracker.exception.LinkExceptionBadURL;
import com.meli.linktracker.exception.LinkExceptionURLEmpty;
import com.meli.linktracker.exception.LinkExceptionURLInactive;
import com.meli.linktracker.exception.LinkExceptionURLNotExists;
import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.LinkResponseDto;
import com.meli.linktracker.service.dto.MetricsDTO;

public interface ILinkService {

    LinkResponseDto createLink(LinkDTO link) throws LinkExceptionURLEmpty, LinkExceptionBadURL;

    LinkDTO getUrlById(Integer id) throws LinkExceptionURLNotExists, LinkExceptionURLInactive;

    MetricsDTO getMetricsByLinkId(Integer id);

    LinkResponseDto invalidateLinkById(Integer id);

}
