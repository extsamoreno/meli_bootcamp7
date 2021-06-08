package com.example.springclase4.project.service.Mapper;

import com.example.springclase4.project.model.Url;
import com.example.springclase4.project.repository.DTO.UrlMetricsDTO;
import com.example.springclase4.project.repository.DTO.UrlRequestDTO;
import com.example.springclase4.project.repository.DTO.UrlSavedDTO;

public class UrlMapper{

    public static Url toUrlModel(UrlRequestDTO urlRequestDTO) {
        return new Url(urlRequestDTO.getUrl(), 0, true, -1);
    }

    public static UrlSavedDTO toUrlSavedDTO(Url url){
        return new UrlSavedDTO(url.getUrl(), Integer.toString(url.getLinkId()));
    }

    public static UrlMetricsDTO toUrlMetricsDto(Url url)
    {
        return new UrlMetricsDTO(url.getUrl(), url.getCounter());
    }
}
