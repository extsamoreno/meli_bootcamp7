package com.example.demo.service.mapper;

import com.example.demo.repository.entities.Url;
import com.example.demo.service.dto.UrlDTO;

public class UrlMapper {
    public static UrlDTO toDTO(Integer i, Url url, String pass) {
        return new UrlDTO(i, url.getUrl(), 0, true, pass);
    }
}