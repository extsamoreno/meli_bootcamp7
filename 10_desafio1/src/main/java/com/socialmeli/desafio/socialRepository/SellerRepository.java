package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.PostModel;
import com.socialmeli.desafio.model.UserModel;
import com.socialmeli.desafio.model.SellerModel;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Data
public class SellerRepository implements ISellerRepository {

    private static HashMap<Integer, SellerModel> dataBaseVendedor = new HashMap<>();  //dataBaseSeller



    public void newSeller(String userName){

        int idNext= dataBaseVendedor.size()+1;
        SellerModel user =new SellerModel(idNext,userName,new ArrayList<PostModel>(),new ArrayList<UserModel>());
        dataBaseVendedor.put(idNext,user);
    }


    public void listSeller(){
        for (int i = 1; i < dataBaseVendedor.size() ; i++) {
            System.out.println(dataBaseVendedor.get(i).getUserName());
        }
    }


    public SellerModel getVendedorById(int id){  //getSellerById
        return dataBaseVendedor.get(id);

    }




}
