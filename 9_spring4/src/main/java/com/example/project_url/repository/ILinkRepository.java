package com.example.project_url.repository;

import com.example.project_url.models.Link;

public interface ILinkRepository {
    Link create(Link link);

    Link getById(int linkId);

    void invalidate(Link link);

    Link getByUrl(String url);
}
