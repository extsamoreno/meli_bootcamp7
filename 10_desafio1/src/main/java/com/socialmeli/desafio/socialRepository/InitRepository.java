package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.Exception.RegisteredFollowerException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.SellerIdNotFoundException;
import com.socialmeli.desafio.service.ISocialService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Data
public class InitRepository implements IInitRepository{

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    ISellerRepository iSellerRepository;

    @Autowired
    ISocialService iSocialService;


    //Aca se van a llamar a los metodos que van a dar de alta una base de datos de prueba
   public void altaUsuarios(){


       iUserRepository.newUser("Usuario 1");
       iUserRepository.newUser("Usuario 2");
       iUserRepository.newUser("Usuario 3");
       iUserRepository.newUser("Usuario 4");
       iUserRepository.newUser("Usuario 5");
       iUserRepository.newUser("Usuario 6");
       iUserRepository.newUser("Usuario 7");


    }

    @Override
    public void altaVendedores() {
        iSellerRepository.newSeller("Vendedor 1");
        iSellerRepository.newSeller("Vendedor 2");
        iSellerRepository.newSeller("Vendedor 3");
        iSellerRepository.newSeller("Vendedor 4");
        iSellerRepository.newSeller("Vendedor 5");
        iSellerRepository.newSeller("Vendedor 6");
        iSellerRepository.newSeller("Vendedor 7");
    }


    public void follow() throws UserIdNotFoundException, SellerIdNotFoundException, RegisteredFollowerException {

        iSocialService.follow(2, 2);
        iSocialService.follow(2, 3);
        iSocialService.follow(1, 1);
        iSocialService.follow(3, 5);
        iSocialService.follow(2, 1);
        iSocialService.follow(3, 1);
        iSocialService.follow(3, 3);

        }


}
