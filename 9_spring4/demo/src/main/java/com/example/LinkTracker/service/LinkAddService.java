package com.example.LinkTracker.service;


import com.example.LinkTracker.model.Url;
import com.example.LinkTracker.repository.IUrlrepository;
import com.example.LinkTracker.service.dto.RequestUrlNewDTO;
import com.example.LinkTracker.service.dto.ResponseMetricDTO;
import com.example.LinkTracker.service.dto.ResponseUrlEnmascar;
import com.example.LinkTracker.service.dto.ResponseUrlNewDTO;
import com.example.LinkTracker.service.mapper.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkAddService {
    @Autowired
    IUrlrepository iUrlrepository;


    public ResponseUrlNewDTO saveUrlNew(RequestUrlNewDTO requestUrlNewDTO){

        Url url;
        url = iUrlrepository.createUrl(requestUrlNewDTO);
        return UrlMapper.requesToResponseNewUrl(url);
    }

    public ResponseUrlEnmascar getUrl(Integer value){

        return UrlMapper.requesToResponseGetUrl(iUrlrepository.getUrl(value));
    }

    public ResponseMetricDTO getMetric(Integer value){

        return UrlMapper.requesToResponseMetricUrl(iUrlrepository.getMetric(value));
    }
    public boolean disableUrl(Integer value){

        return iUrlrepository.disableUrl(value);
    }
}
