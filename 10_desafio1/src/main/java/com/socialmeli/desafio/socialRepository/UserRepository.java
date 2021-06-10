package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Data
public class UserRepository implements IUserRepository {

    private static HashMap <Integer, UsuarioModel> UserDataBase = new HashMap<>();



  public void altaUsuario(String userName){  //newUser

        int idNext= UserDataBase.size()+1;

        UsuarioModel user =new UsuarioModel(idNext,userName, new ArrayList<VendedorModel>());

        UserDataBase.put(idNext,user);
    }


     public void listarUsuarios(){ //listUsers
         for (int i = 1; i < UserDataBase.size() ; i++) {
             System.out.println(UserDataBase.get(i).getUserName());
         }
    }


    //busco usuario por ID y lo retorno
    public UsuarioModel getUsuarioById(int id){  //getUserById
      return UserDataBase.get(id);

    }


}
