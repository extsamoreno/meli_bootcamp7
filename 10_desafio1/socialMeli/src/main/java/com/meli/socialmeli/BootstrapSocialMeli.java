package com.meli.socialmeli;

import com.meli.socialmeli.repository.product.IProductRepository;
import com.meli.socialmeli.repository.user.IUserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootstrapSocialMeli implements InitializingBean {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IProductRepository productRepository;

    /**
     * to automatically initialize the databases
     */
    @Override
    public void afterPropertiesSet() {
        System.out.println("*******************************");
        System.out.println("**** INITIALIZING DATABASE ****");
        userRepository.loadDatabase();
        productRepository.loadDatabase();
        System.out.println("*******************************");
        System.out.println("********* COMPLETED ***********");
    }
}
