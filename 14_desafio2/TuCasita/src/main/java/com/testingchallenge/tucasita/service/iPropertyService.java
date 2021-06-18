package com.testingchallenge.tucasita.service;

import com.testingchallenge.tucasita.dto.*;
import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import org.springframework.http.HttpStatus;

public interface iPropertyService {
    public PropertyDTO getArea (String name) throws PropertyNotFoundException;
    public PropertyValueDTO getValue (String name) throws PropertyNotFoundException;
    public PropertyRoomsDTO getRoomArea (String name) throws PropertyNotFoundException;
    public BiggerRoomDTO getTheBiggerRoom(String name) throws PropertyNotFoundException;
    public HttpStatus addProperty (PropertyReqDTO propertyReqDTO) throws NeighborhoodNotFoundException;
}
