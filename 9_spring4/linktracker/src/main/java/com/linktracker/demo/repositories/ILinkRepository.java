package com.linktracker.demo.repositories;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.exceptions.LinkIDNotValidException;
import com.linktracker.demo.models.Link;

import java.util.ArrayList;

public interface ILinkRepository {
    Link addLink(Link link);
    Link findLinkByUrl(String url);
    Link findLinkByID(int id);
    int getLinkReport(int id);
    void incrementLinkReport(int id);
    boolean invalidateLink(int id);
    boolean isLinkActive(int id);
    void log();
}
