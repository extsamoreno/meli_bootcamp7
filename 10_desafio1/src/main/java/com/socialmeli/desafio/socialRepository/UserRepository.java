package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.UserModel;
import com.socialmeli.desafio.model.SellerModel;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Data
public class UserRepository implements IUserRepository {

    private static HashMap <Integer, UserModel> UserDataBase = new HashMap<>();



  public void newUser(String userName){

        int idNext= UserDataBase.size()+1;

        UserModel user =new UserModel(idNext,userName, new ArrayList<SellerModel>());

        UserDataBase.put(idNext,user);
    }


     public void listUsers(){
         for (int i = 1; i < UserDataBase.size() ; i++) {
             System.out.println(UserDataBase.get(i).getUserName());
         }
    }


    //busco usuario por ID y lo retorno
    public UserModel getUsuarioById(int id){
      return UserDataBase.get(id);

    }


}
