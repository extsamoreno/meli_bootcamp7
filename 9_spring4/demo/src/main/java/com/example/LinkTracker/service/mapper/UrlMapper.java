package com.example.LinkTracker.service.mapper;

import com.example.LinkTracker.service.dto.ResponseMetricDTO;
import com.example.LinkTracker.service.dto.ResponseUrlEnmascar;
import com.example.LinkTracker.service.dto.ResponseUrlNewDTO;
import com.example.LinkTracker.model.Url;

public class UrlMapper {
    public static ResponseUrlNewDTO requesToResponseNewUrl(Url url){
        
        return new ResponseUrlNewDTO(url.getId());
    }
    public static ResponseUrlEnmascar requesToResponseGetUrl(String url){

        return new ResponseUrlEnmascar(url);
    }

    public static ResponseMetricDTO requesToResponseMetricUrl(Integer value){

        return new ResponseMetricDTO(value);
    }
}
