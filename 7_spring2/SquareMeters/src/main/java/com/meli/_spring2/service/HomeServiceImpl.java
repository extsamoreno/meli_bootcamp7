package com.meli._spring2.service;

import com.meli._spring2.dto.HomeDTO;
import com.meli._spring2.dto.HomeValueDTO;
import com.meli._spring2.dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Stream;

@Service
public class HomeServiceImpl implements IHomeService {

    @Override
    public float calculateHomeValue(HomeDTO home, float meterValue) {
        float metersTotal = 0;
        float value = 0;
        for (RoomDTO room : home.getRoomDTOList()) {
            float meterRoom = room.getSquareMeters() ;
            metersTotal += meterRoom;
        }
        value = metersTotal * 800f;
        return value;
    }

    public HomeValueDTO getHomeValue(HomeDTO home) {
        HomeValueDTO result = new HomeValueDTO();
        result.setHomeName( home.getName());
        result.setBiggestRoom(home.getBiggetsRoom());
        float metersValueTotal = calculateHomeValue(home, 800f);
        result.setValue(metersValueTotal);
        return result;
    }
}
