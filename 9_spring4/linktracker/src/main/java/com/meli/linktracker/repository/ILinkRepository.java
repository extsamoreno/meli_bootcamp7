package com.meli.linktracker.repository;

import com.meli.linktracker.model.Link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ILinkRepository {

    Link save(Link link);

    Link findById(Integer id);

    Link findByUrl(String url);

    void updateLink(Link link);

}
