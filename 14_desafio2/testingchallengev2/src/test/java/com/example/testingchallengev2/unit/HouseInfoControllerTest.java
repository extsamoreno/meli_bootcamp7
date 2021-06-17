package com.example.testingchallengev2.unit;

import com.example.testingchallengev2.controller.HouseInfoController;
import com.example.testingchallengev2.service.IHouseInfoService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HouseInfoControllerTest {

    @Mock
    IHouseInfoService iHouseInfoService;

    @InjectMocks
    HouseInfoController houseInfoController;

    

}
