package com.spring4.linktracker.service;

import com.spring4.linktracker.exception.TrackerIdNotFoundException;
import com.spring4.linktracker.service.dtos.LinkDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrackerService {
    LinkDTO generateLink (String url);
    List<LinkDTO> allLinks();
    ResponseEntity<Void> redirectLink(int id) throws TrackerIdNotFoundException;
    LinkDTO getMetrics(int id) throws TrackerIdNotFoundException;
    void invalidateLink(int id);
}
