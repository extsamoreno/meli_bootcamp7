package com.example.springclase4.project.repository;

import com.example.springclase4.project.model.Url;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UrlRepository implements IUrlRepository{

    private HashMap<Integer, Url> urlsDict = new HashMap<>();


    @Override
    public Url createUrl(Url url) {
        url.setLinkId(urlsDict.size() + 1);
        urlsDict.put(url.getLinkId(), url);
        return url;
    }

    @Override
    public Url updateUrl(Url url) {
        urlsDict.put(url.getLinkId(), url);
        return url;
    }

    @Override
    public Url getUrlById(Integer urlId) {
        return urlsDict.get(urlId);
    }

    @Override
    public HashMap<Integer, Url> getUrlsList() {
        return urlsDict;
    }

    @Override
    public Integer findUrlKey(String url) {
        Integer key = -1;
        for (int i = 1; i < urlsDict.size();) {
            if (getUrlById(i).getUrl().equals(url)){
                key = i;
                break;
            }
            else
            {
                i++;
            }
        }
        return key;
    }
}
