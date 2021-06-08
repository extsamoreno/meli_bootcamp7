package com.meli.demo.services.mappers;

import com.meli.demo.dtos.CantidadUsuariosDTO;
import com.meli.demo.dtos.ListaVendedoresResponseDTO;
import com.meli.demo.dtos.ListadoUsuariosResponseDTO;
import com.meli.demo.exceptions.FollowException;
import org.springframework.stereotype.Service;


public interface SocialService {

    String Follow(int userid, int  usertofollow) throws FollowException;
    CantidadUsuariosDTO countUsers(int iduser);
    ListadoUsuariosResponseDTO listUsers(int iduser);
    ListaVendedoresResponseDTO listVendedores(int iduser);
}
