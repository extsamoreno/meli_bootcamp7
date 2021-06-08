package com.meli.demo.repositories;


import com.meli.demo.dtos.CantidadUsuariosDTO;
import com.meli.demo.dtos.ListaVendedoresResponseDTO;
import com.meli.demo.dtos.ListadoUsuariosResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository {
    boolean Follow(int iduser, int id_vendedor);

    void cargarDatos();

    CantidadUsuariosDTO countUsers(int iduser);
    ListadoUsuariosResponseDTO listUsers(int iduser);
    ListaVendedoresResponseDTO listVendedores(int iduser);



}
