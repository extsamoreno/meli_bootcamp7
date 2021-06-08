package com.meli.linkTracker.repository;

import com.meli.linkTracker.dto.UrlDto;
import com.meli.linkTracker.dto.UrlInputDto;
import com.meli.linkTracker.mapper.UrlMapper;
import com.meli.linkTracker.model.Url;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UrlRepository implements IUrlRepository{
    private ArrayList<Url> urlList;

    public UrlRepository() {
        urlList = new ArrayList<>();
    }

    @Override
    public String addUrl(UrlInputDto newUrl) {
        Url temp=UrlMapper.InputDtoToUrl(newUrl);
        temp.setId(String.valueOf(urlList.size()));
        urlList.add(temp);
        return String.valueOf(temp.getId());
    }

    @Override
    public ArrayList<Url> getUrlList(){
        return urlList;
    }

    @Override
    public void update(Url url, int index) {
        urlList.get(index).setUrl(url.getUrl());
        urlList.get(index).setActive(url.isActive());
        urlList.get(index).setVisits(url.getVisits());
        System.out.println(urlList.get(index).getVisits());
    }
}
