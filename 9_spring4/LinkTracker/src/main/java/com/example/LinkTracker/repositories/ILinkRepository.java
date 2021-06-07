package com.example.LinkTracker.repositories;

import com.example.LinkTracker.exception.LinkIdNotFoundException;
import com.example.LinkTracker.models.Link;

import java.util.Map;

public interface ILinkRepository {
    Integer createLink(Link link);
    Map<Integer, Link> getLinks();
}
