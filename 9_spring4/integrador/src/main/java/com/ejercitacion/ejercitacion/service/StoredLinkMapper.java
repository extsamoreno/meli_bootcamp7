package com.ejercitacion.ejercitacion.service;

import com.ejercitacion.ejercitacion.dto.LinkIdResponse;
import com.ejercitacion.ejercitacion.dto.LinkRedirectionStadisticsResponse;
import com.ejercitacion.ejercitacion.dto.StoreLinkRequest;
import com.ejercitacion.ejercitacion.entity.StoredLink;

public class StoredLinkMapper {

    public static StoredLink toEntity(StoreLinkRequest request) {

        return new StoredLink(null, request.getUrl(), 0, true, request.getPassword());
    }

    public static LinkRedirectionStadisticsResponse toRedirectionStadisticsResponse(StoredLink storedLink) {
        return new LinkRedirectionStadisticsResponse(storedLink.getUrl().toString(), storedLink.getRedirectionsCounter());
    }

    public static LinkIdResponse toLinkIdResponse(StoredLink storedLink) {
        return new LinkIdResponse(storedLink.getId());
    }
}
