package com.example.demo.repositories;

import com.example.demo.models.Link;

import java.net.URL;

public interface ILinkRepository {

    public int add(Link link);

//    Link getLinkbyUrl(URL url);

    Link getLinkById(int id);

    void increaseCount(int id);

    void deactiveById(int id);


}
