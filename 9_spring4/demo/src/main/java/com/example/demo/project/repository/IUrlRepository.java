package com.example.demo.project.repository;

import com.example.demo.project.exception.UrlIdNotFoundException;
import com.example.demo.project.models.Url;

public interface IUrlRepository {

    Url getById(Integer id) throws UrlIdNotFoundException;

    Integer addUrl(Url url);
}
