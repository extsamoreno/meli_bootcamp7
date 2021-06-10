package com.desafio1.meli;

import com.desafio1.meli.repository.userRepository.IUserrepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootstrapInit implements InitializingBean {
    @Autowired
    IUserrepository iUserrepository;


    @Override
    public void afterPropertiesSet() {
        System.out.println("*******************************");
        System.out.println("**** INITIALIZING DATABASE ****");
        iUserrepository.loadRepository();
        System.out.println("*******************************");
        System.out.println("********* COMPLETED ***********");
    }
}
