package com.example.linktracker.repository;

import com.example.linktracker.model.Link;

public interface iLinkRepository {

    Link saveLink(Link link);
    Link findLinkByID(Integer id);

}
