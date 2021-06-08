package com.example.LinkTracker.repository;

import com.example.LinkTracker.service.dto.LinkDTO;

import java.util.Optional;

public interface ILinkRepository {
    LinkDTO save(LinkDTO link);
    LinkDTO findByLinkId(Integer id);
    void delete(LinkDTO linkDTO);
}
