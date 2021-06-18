package com.example.challenge2.unit;

import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.repositories.IDistrictDAO;
import com.example.challenge2.serivces.DistrictService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {
    @Mock
    IDistrictDAO districtDAO;

    @InjectMocks
    DistrictService districtService;

/*
    District create(District district);
    District find(String districtName) throws DistrictNotFoundException;
    Boolean exist(String districName) throws DistrictNotFoundException;*/


}
