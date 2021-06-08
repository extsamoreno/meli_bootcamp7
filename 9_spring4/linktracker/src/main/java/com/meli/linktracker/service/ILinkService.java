package com.meli.linktracker.service;

import com.meli.linktracker.exception.*;
import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.LinkResponseDto;
import com.meli.linktracker.service.dto.MetricsDTO;

public interface ILinkService {

    LinkResponseDto createLink(LinkDTO link) throws LinkExceptionURLEmpty, LinkExceptionBadURL;

    LinkDTO getUrlById(Integer id, String password) throws LinkExceptionURLNotExists, LinkExceptionURLInactive, LinkExceptionBadPassword;

    MetricsDTO getMetricsByLinkId(Integer id);

    LinkResponseDto invalidateLinkById(Integer id);



}
