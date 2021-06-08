package com.meli.linkTracker.repository;

import com.meli.linkTracker.dto.UrlDto;
import com.meli.linkTracker.dto.UrlInputDto;
import com.meli.linkTracker.model.Url;

import java.util.ArrayList;

public interface IUrlRepository {
    public String addUrl(UrlInputDto newUrl);

    ArrayList<Url> getUrlList();

    void update(Url ulr, int index);
}
