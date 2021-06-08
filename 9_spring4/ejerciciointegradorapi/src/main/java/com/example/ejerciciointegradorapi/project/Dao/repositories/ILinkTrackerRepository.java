package com.example.ejerciciointegradorapi.project.Dao.repositories;

import com.example.ejerciciointegradorapi.project.Dao.models.LinkTracker;
import com.example.ejerciciointegradorapi.project.exceptions.InvalidUrlException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ILinkTrackerRepository {
    public LinkTracker saveUrl (String url) throws InvalidUrlException;
    public LinkTracker addRedirect (Integer linkId) throws InvalidUrlException;

    LinkTracker getByLinkId(Integer linkId) throws InvalidUrlException;

    public void invalidateByLinkId (Integer linkId);

}
