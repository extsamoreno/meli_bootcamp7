package com.example.demo.project.service.mapper;

import com.example.demo.project.models.Url;
import com.example.demo.project.service.dto.UrlDTO;

public class UrlMapper {

    public static UrlDTO toDTO(Url url){
        return new UrlDTO(url.getUrl(), url.getPassword(), url.getCounter(), url.getId(), url.isValid());
    }

    public static Url toUrl(UrlDTO url){
        return new Url(url.getUrl(), url.getPassword(), url.getCounter(), url.getId(), url.isValid());
    }
}
