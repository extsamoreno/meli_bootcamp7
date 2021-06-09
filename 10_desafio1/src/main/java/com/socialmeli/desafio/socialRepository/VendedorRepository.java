package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.UsuarioModel;
import com.socialmeli.desafio.model.VendedorModel;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Repository
@Data
public class VendedorRepository implements IVendedorRepository {

    private static HashMap<Integer, VendedorModel> dataBaseVendedor = new HashMap<>();



    public void altaVendedor(String userName){

        int idNext= dataBaseVendedor.size()+1;
        VendedorModel user =new VendedorModel(idNext,userName,new ArrayList<PublicacionModel>(),new ArrayList<UsuarioModel>());
        dataBaseVendedor.put(idNext,user);
    }


    public void listarVendedores(){
        for (int i = 1; i < dataBaseVendedor.size() ; i++) {
            System.out.println(dataBaseVendedor.get(i).getUserName());
        }
    }


    public VendedorModel getVendedorById(int id){  //busco vendedor por ID y lo retorna
        return dataBaseVendedor.get(id);

    }




}
