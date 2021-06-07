package com.example.LinkTracker.service;

import com.example.LinkTracker.service.dto.RequestUrlNewDTO;
import com.example.LinkTracker.service.dto.ResponseUrlEnmascar;
import com.example.LinkTracker.service.dto.ResponseUrlNewDTO;

public interface ILinkAddService {
    ResponseUrlNewDTO saveUrlNew(RequestUrlNewDTO requestUrlNewDTO);
    ResponseUrlEnmascar getUrl(Integer value);
    ResponseUrlEnmascar getMetric(String value);
    boolean disableUrl(Integer value);
}
