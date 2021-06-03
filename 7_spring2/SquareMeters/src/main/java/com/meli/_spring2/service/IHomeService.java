package com.meli._spring2.service;

import com.meli._spring2.dto.HomeDTO;
import com.meli._spring2.dto.HomeValueDTO;

public interface IHomeService {

    public float calculateHomeValue(HomeDTO home, float meterValue);

    public HomeValueDTO getHomeValue(HomeDTO home);
}
