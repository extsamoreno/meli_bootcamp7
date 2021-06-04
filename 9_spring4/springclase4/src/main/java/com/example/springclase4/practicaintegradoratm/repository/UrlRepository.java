package com.example.springclase4.practicaintegradoratm.repository;

import com.example.springclase4.practicaintegradoratm.model.Url;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UrlRepository implements IUrlRepository{

    private HashMap<Integer, Url> urlsDict = new HashMap<>();


    @Override
    public Boolean createUrl(Url url) {
        url.setKey(urlsDict.size() + 1);
        urlsDict.put(url.getKey(), url);
        return true;
    }

    @Override
    public Boolean updateUrl(Url url) {
        urlsDict.put(url.getKey(), url);
        return null;
    }

    @Override
    public Url getUrlById(Integer urlId) {
        return urlsDict.get(urlId);
    }
}
