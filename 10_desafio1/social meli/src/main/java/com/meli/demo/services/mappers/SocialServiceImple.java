package com.meli.demo.services.mappers;


import com.meli.demo.dtos.CantidadUsuariosDTO;
import com.meli.demo.dtos.ListaVendedoresResponseDTO;
import com.meli.demo.dtos.ListadoUsuariosResponseDTO;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.repositories.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SocialServiceImple implements SocialService {


    @Autowired
    SocialRepository FollowRepository;

    @Override
    public String Follow(int userid, int usertofollow) throws FollowException {

        FollowRepository.cargarDatos();

        if(FollowRepository.Follow(userid,usertofollow)){
            return "ok";
        }
        else{
            throw new FollowException();
        }

    }

    @Override
    public CantidadUsuariosDTO countUsers(int userid) {
        FollowRepository.cargarDatos();
        return FollowRepository.countUsers(userid);
    }

    @Override
    public ListadoUsuariosResponseDTO listUsers(int iduser) {
        FollowRepository.cargarDatos();
        return FollowRepository.listUsers(iduser);
    }

    @Override
    public ListaVendedoresResponseDTO listVendedores(int iduser) {
        FollowRepository.cargarDatos();
        return FollowRepository.listVendedores(iduser);
    }
}
