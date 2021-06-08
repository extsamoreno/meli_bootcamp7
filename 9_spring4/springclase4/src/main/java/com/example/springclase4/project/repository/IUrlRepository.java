package com.example.springclase4.project.repository;

import com.example.springclase4.project.model.Url;

import java.util.HashMap;

public interface IUrlRepository {

    Url createUrl(Url url);
    Url updateUrl(Url url);
    Url getUrlById(Integer urlId);
    HashMap<Integer, Url> getUrlsList();


    Integer findUrlKey(String url);
}
