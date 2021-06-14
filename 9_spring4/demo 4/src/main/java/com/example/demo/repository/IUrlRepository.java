package com.example.demo.repository;

import com.example.demo.Exceptions.LinkNotFoundException;
import com.example.demo.repository.entities.Url;
import com.example.demo.service.dto.UrlDTO;

import java.util.HashMap;
import java.util.Map;

public interface IUrlRepository {

    Map<Integer, UrlDTO> openOrCreateLinkTackerRepository();
    UrlDTO getItemLinkTrackerRepositoryById(Integer i);
    Integer updateLinkTrackerRepository(Url url);
    boolean invalidateLinkTrackerRepository(Integer i);
    boolean updateLinkDTOCount(Integer i);
}
