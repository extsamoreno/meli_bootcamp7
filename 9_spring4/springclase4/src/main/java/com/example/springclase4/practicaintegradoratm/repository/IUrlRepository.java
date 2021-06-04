package com.example.springclase4.practicaintegradoratm.repository;

import com.example.springclase4.practicaintegradoratm.model.Url;

public interface IUrlRepository {

    Boolean createUrl(Url url);
    Boolean updateUrl(Url url);
    Url getUrlById(Integer urlId);



}
