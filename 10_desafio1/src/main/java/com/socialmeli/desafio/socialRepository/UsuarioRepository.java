package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class UsuarioRepository implements IUsuarioRepository{

    private static HashMap <Integer, UsuarioModel> dataBaseUsuario = new HashMap<>();




  public void altaUsuario(String userName){

        int idNext= dataBaseUsuario.size()+1;

        UsuarioModel user =new UsuarioModel(idNext,userName, new ArrayList<VendedorModel>());

        dataBaseUsuario.put(idNext,user);


    }


     public void listarUsuarios(){

         for (int i = 1; i < dataBaseUsuario.size() ; i++) {

             System.out.println(dataBaseUsuario.get(i).getUserName());
         }
    }



    public UsuarioModel getUsuarioById(int id){  //busco usuario por ID y lo retorno
      return dataBaseUsuario.get(id);

    }


}
