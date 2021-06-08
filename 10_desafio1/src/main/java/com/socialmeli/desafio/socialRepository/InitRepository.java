package com.socialmeli.desafio.socialRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Data
public class InitRepository implements IInitRepository{

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    IVendedorRepository iVendedorRepository;


    //Aca se van a llamar a los metodos que van a dar de alta una base de datos de prueba
   public void altaUsuarios(){


       iUsuarioRepository.altaUsuario("Usuario 1");
       iUsuarioRepository.altaUsuario("Usuario 2");
       iUsuarioRepository.altaUsuario("Usuario 3");
       iUsuarioRepository.altaUsuario("Usuario 4");





    }

    @Override
    public void altaVendedores() {
        iVendedorRepository.altaVendedor("Vendedor 1");
        iVendedorRepository.altaVendedor("Vendedor 2");
        iVendedorRepository.altaVendedor("Vendedor 3");
        iVendedorRepository.altaVendedor("Vendedor 4");
    }


}
