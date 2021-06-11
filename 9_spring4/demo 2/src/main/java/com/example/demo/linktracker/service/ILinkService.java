package com.example.demo.linktracker.service;

import com.example.demo.linktracker.service.dto.LinkDTO;
import org.springframework.stereotype.Service;

@Service
public interface ILinkService {
    LinkDTO getCreateLink (String url);
    boolean validateLink (String url);
    String getUrl(int linkId);
}
