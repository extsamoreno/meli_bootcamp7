package com.example.LinkTracker.repositories;

import com.example.LinkTracker.models.Link;

import java.util.Map;

public interface ILinkRepository {
    Map<Integer, Link> loadDataBase();
}
