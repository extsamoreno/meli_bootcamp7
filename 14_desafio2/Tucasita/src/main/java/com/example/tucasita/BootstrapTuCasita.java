package com.example.tucasita;

import com.example.tucasita.repository.IHouseRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootstrapTuCasita implements InitializingBean {
    @Autowired
    IHouseRepository houseRepository;

    /**
     * to automatically initialize the databases
     */
    @Override
    public void afterPropertiesSet() {
        System.out.println("*******************************");
        System.out.println("**** INITIALIZING DATABASE ****");
        houseRepository.loadDatabase();
        System.out.println("*******************************");
        System.out.println("********* COMPLETED ***********");
    }
}
