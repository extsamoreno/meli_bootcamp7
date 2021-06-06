package com.linktracker.api.service;

import com.linktracker.api.dto.*;
import com.linktracker.api.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;

@Service
public interface LinkTrackerService {
    NewLinkResponseDTO addLink(NewLinkResquestDTO newLinkResquestDTO);
    HttpHeaders redirectToUrl(int id, String password) throws URISyntaxException, LinkTrackerException;
    MetricsDTO metricsByID (int id) throws LinkTrackerBadIdException;
    InvalidateDTO invalidateById (int id) throws LinkTrackerBadIdException;

}
