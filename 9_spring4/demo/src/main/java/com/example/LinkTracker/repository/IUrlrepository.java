package com.example.LinkTracker.repository;

import com.example.LinkTracker.model.Url;
import com.example.LinkTracker.service.dto.RequestUrlNewDTO;

public interface IUrlrepository {
    Url createUrl(RequestUrlNewDTO requestUrlNewDTO);
    String getUrl(Integer value);
    Integer getMetric(Integer value);
    boolean disableUrl(Integer value);
}
