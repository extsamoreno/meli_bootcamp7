package com.linktracker.demo.repositories;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.exceptions.LinkNotFoundException;
import com.linktracker.demo.models.Link;

import java.util.ArrayList;

public interface ILinkRepository {
    Link addLink(Link link);
    Link findLinkByUrl(String url);
    Link findLinkById(Integer id, String password);
    void addLinkCounter(Integer id);
    Integer getLinkCounter(Integer id) throws LinkNotFoundException;
    Link invalidateLinkByUrl(Integer id) throws LinkNotFoundException;
}
