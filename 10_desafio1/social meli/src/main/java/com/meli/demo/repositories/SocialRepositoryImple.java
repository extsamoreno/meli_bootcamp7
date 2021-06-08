package com.meli.demo.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.demo.dtos.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

@Data
@NoArgsConstructor
@AllArgsConstructor


public class SocialRepositoryImple implements SocialRepository {

    private ArrayList<UsuarioDTO> Usuarios =new ArrayList<>();
    private ArrayList<UsuarioDTO> Usuariosasigandos =new ArrayList<>();
    private ArrayList<UsuarioDTO> Usuariosasigandos2 =new ArrayList<>();
    private ArrayList<VendedorDTO> Vendedores =new ArrayList<>();



    VendedorDTO ven1 = new VendedorDTO();
    VendedorDTO ven2 = new VendedorDTO();

    ArrayList<PublicacionDTO> publicaciones = new ArrayList<>();
    ArrayList<PublicacionDTO> publicaciones2 = new ArrayList<>();
    public void cargarDatos(){

        UsuarioDTO user1 = new UsuarioDTO(1,"Juanito");
        UsuarioDTO user2 = new UsuarioDTO(2,"maria");
        UsuarioDTO user3 = new UsuarioDTO(3,"pedro");
        UsuarioDTO user4 = new UsuarioDTO(4,"naho");
        UsuarioDTO user5 = new UsuarioDTO(5,"use5");
        UsuarioDTO user6 = new UsuarioDTO(6,"user6");
        UsuarioDTO user7 = new UsuarioDTO(7,"user7");
        UsuarioDTO user8 = new UsuarioDTO(8,"user8");
        UsuarioDTO user9 = new UsuarioDTO(9,"user9");

        Usuariosasigandos.add(user6);
        Usuariosasigandos.add(user7);
        Usuariosasigandos2.add(user8);
        Usuariosasigandos2.add(user6);


        /*PublicacionDTO pub1 = new PublicacionDTO(1,"Semana","Esta es la primera publicacion");


        PublicacionDTO pub2 = new PublicacionDTO(2,"q hubo","Esta es la segunda publicacion");

        publicaciones.add(pub1);
        publicaciones2.add(pub2);
        */

        Usuarios.add(user1);
        Usuarios.add(user2);
        Usuarios.add(user3);
        Usuarios.add(user4);
        Usuarios.add(user5);
        Usuarios.add(user6);
        Usuarios.add(user7);
        Usuarios.add(user8);
        Usuarios.add(user9);




        VendedorDTO ven = new VendedorDTO(1,"Pepito perez",publicaciones,Usuariosasigandos);
        VendedorDTO ven2 = new VendedorDTO(2,"maria perez",publicaciones2,Usuariosasigandos2);
        Vendedores.add(ven);
        Vendedores.add(ven2);

    }

    @Override
    public boolean Follow(int iduser, int id_vendedor) {

        UsuarioDTO usuario1 = new UsuarioDTO();
        for (int i = 0; i < Usuarios.size(); i++) {

            if(Usuarios.get(i).getUserId()==iduser){
                usuario1.setUserName(Usuarios.get(i).getUserName());
                usuario1.setUserId(Usuarios.get(i).getUserId());
            }
        }
        for (int i = 0; i < Vendedores.size(); i++) {

            if(Vendedores.get(i).getId()==id_vendedor){

                if(usuario1.getUserName().isEmpty()){
                    return false;
                }else{
                    Vendedores.get(i).getUsuarios().add(usuario1);
                    return true;
                }
            }else{
                return false;

            }
        }

        return true;

    }

    public CantidadUsuariosDTO  countUsers(int iduser){
        CantidadUsuariosDTO cantidad=  new CantidadUsuariosDTO();

        for (int i = 0; i < Vendedores.size(); i++) {

            if(Vendedores.get(i).getId()==iduser){

                cantidad.setUserid(Vendedores.get(i).getId());
                cantidad.setUserName(Vendedores.get(i).getNombre());
                cantidad.setFollowers_count(Vendedores.get(i).getUsuarios().size());

            }
        }

        return cantidad;
    }

    public ListadoUsuariosResponseDTO listUsers(int iduser){
        ListadoUsuariosResponseDTO list=  new ListadoUsuariosResponseDTO();
        System.out.println(iduser);
        for (int i = 0; i < Vendedores.size(); i++) {

            if(Vendedores.get(i).getId()==iduser){

                list.setId(Vendedores.get(i).getId());
                list.setNombre(Vendedores.get(i).getNombre());
                list.setUsuarios(Vendedores.get(i).getUsuarios());

            }
        }

        return list;
    }

    @Override
    public ListaVendedoresResponseDTO listVendedores(int iduser) {
        ListaVendedoresResponseDTO listVen =new ListaVendedoresResponseDTO();

        ArrayList<VendedorResponseDTO> vendedores= new ArrayList<>();

        for (int i = 0; i < Usuarios.size(); i++) {
            if(Usuarios.get(i).getUserId()==iduser){
                listVen.setUserId(Usuarios.get(i).getUserId());
                listVen.setUserName(Usuarios.get(i).getUserName());

                for (int j = 0; j < Vendedores.size(); j++) {

                    if(Vendedores.get(j).getUsuarios().get(j).getUserId()==iduser){

                        VendedorResponseDTO vendedor = new VendedorResponseDTO(Vendedores.get(j).getId(),Vendedores.get(j).getNombre());
                        vendedores.add(vendedor);

                    }
                }

            }

        }
        listVen.setFollowed(vendedores);
        return listVen;
    }



    /*public List<StarwarsjDTO> cargarBaseDeDatos() {
        File baseDeDatos = null;
        try {
            baseDeDatos = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarwarsjDTO>> typeReference = new TypeReference<>() {};
        List<StarwarsjDTO> personasRepositories = null;
        try{
            personasRepositories = objectMapper.readValue(baseDeDatos, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }

        return personasRepositories;
    }*/
}
