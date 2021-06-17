package com.example.demo.service;

import com.example.demo.models.Environment;
import com.example.demo.models.House;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public interface IHouseService {

    double calculateM2(House house);
    double calculateM2Environment(Environment environment);
    double calculatePrice(House house);
    String biggestEnvironment(House house);
    ArrayList<String> environmentM2 (House house);
}
