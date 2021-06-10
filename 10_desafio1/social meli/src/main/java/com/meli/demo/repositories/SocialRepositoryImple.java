package com.meli.demo.repositories;

import com.meli.demo.dtos.*;
import com.meli.demo.models.CountUser;
import com.meli.demo.models.ListSeller;
import com.meli.demo.models.Post;
import com.meli.demo.models.Seller;
import com.meli.demo.models.ListSellerPost;
import com.meli.demo.services.mappers.PostMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.util.*;

@Repository

@Data
@NoArgsConstructor
@AllArgsConstructor


public class SocialRepositoryImple implements SocialRepository {


    private ArrayList<UserDTO> userAsigned1 =new ArrayList<>();
    private ArrayList<UserDTO> userAsigned2 =new ArrayList<>();
    private ArrayList<UserDTO> userAsigned3 =new ArrayList<>();
    private ArrayList<Seller> Sellers =new ArrayList<>();



    SellerDTO ven1 = new SellerDTO();
    SellerDTO ven2 = new SellerDTO();

    ArrayList<PostDTO> Arraypost1 = new ArrayList<>();
    ArrayList<PostDTO> Arraypost2 = new ArrayList<>();
    ArrayList<PostDTO> Arraypost3 = new ArrayList<>();
    ArrayList<UserDTO> UserDTO = new ArrayList<>();

    ArrayList<PostResponseDTO> postDto1 = new ArrayList<>();
    ArrayList<PostResponseDTO> postDto2 = new ArrayList<>();
    ArrayList<PostResponseDTO> postDto3 = new ArrayList<>();
    //Cargamos la informaciòn poara trabajar
    public void cargarDatos(){

        UserDTO user1 = new UserDTO(101,"Comprador Juanito");
        UserDTO user2 = new UserDTO(102,"Comprador Maria");
        UserDTO user3 = new UserDTO(103,"Comprador Pedro");
        UserDTO user4 = new UserDTO(104,"Comprador Hanomy");
        UserDTO user5 = new UserDTO(105,"Comprador Camilo");
        UserDTO user6 = new UserDTO(106,"Comprador Juan");
        UserDTO user7 = new UserDTO(107,"Comprador Jesus");
        UserDTO user8 = new UserDTO(108,"Comprador Mario");
        UserDTO user9 = new UserDTO(109,"Comprador Ana");
        UserDTO user10 = new UserDTO(110,"Comprador Felipe");
        UserDTO user11 = new UserDTO(111,"Comprador Anacarina");
        UserDTO user12 = new UserDTO(112,"Comprador Wilmer");
        UserDTO user13 = new UserDTO(113,"Comprador Bogota");
        UserDTO user14 = new UserDTO(114,"Comprador Suirt");
        UserDTO user15 = new UserDTO(115,"Comprador Claudia");

        UserDTO.add(user1);
        UserDTO.add(user2);
        UserDTO.add(user2);
        UserDTO.add(user3);
        UserDTO.add(user4);
        UserDTO.add(user5);
        UserDTO.add(user6);
        UserDTO.add(user7);
        UserDTO.add(user8);
        UserDTO.add(user9);
        UserDTO.add(user10);
        UserDTO.add(user11);
        UserDTO.add(user12);
        UserDTO.add(user13);
        UserDTO.add(user14);
        UserDTO.add(user15);


        userAsigned1.add(user1);
        userAsigned1.add(user9);
        userAsigned1.add(user2);
        userAsigned2.add(user3);
        userAsigned2.add(user8);
        userAsigned2.add(user4);
        userAsigned3.add(user6);
        userAsigned3.add(user5);
        userAsigned3.add(user7);
        userAsigned3.add(user1);

        DetailDTO Detail01 = new DetailDTO(1,"Pala para tierra","Juego","Test1","gris","Test1");
        DetailDTO Detail02 = new DetailDTO(2,"Pc mac","Computador","Test2","plateado","Test2");
        DetailDTO Detail03 = new DetailDTO(1,"Cable Usb","Cable","Test3","negro","Test3");
        DetailDTO Detail04 = new DetailDTO(2,"Celular samsung","Celular","Test4","rojo","Test4");
        DetailDTO Detail05 = new DetailDTO(2,"Walmart test","tienda","Test5","rojo","Test5");
        DetailDTO Detail06 = new DetailDTO(2,"Angulo test","regla","Test6","rojo","Test6");

        PostDTO post1 = new PostDTO(401,201,"01-05-2021",Detail01,100,1500.0,false,0.0);
        PostDTO post2 = new PostDTO(402,202,"20-12-2021",Detail02,100,1202.0,false,0.0);
        PostDTO post3 = new PostDTO(403,203,"10-07-2021",Detail03,100,1530.0,false,0.0);
        PostDTO post4 = new PostDTO(404,204,"09-06-2021",Detail04,200,400.0,false,0.0);
        PostDTO post5 = new PostDTO(405,205,"07-06-2021",Detail05,200,100.0,false,0.0);
        PostDTO post6 = new PostDTO(406,206,"03-06-2021",Detail06,200,420.0,false,0.0);
        PostDTO post7 = new PostDTO(501,301,"21-05-2021",Detail01,100,1500.0,true,1.0);
        PostDTO post8 = new PostDTO(502,302,"27-02-2021",Detail02,200,1400.0,true,23.0);
        PostDTO post9 = new PostDTO(503,303,"29-05-2019",Detail03,100,1450.0,true,8.0);
        PostDTO post10 = new PostDTO(504,304,"30-07-2021",Detail04,200,300.0,true,6.0);

        Arraypost1.add(post1);
        Arraypost2.add(post2);
        Arraypost3.add(post3);
        Arraypost3.add(post4);
        Arraypost3.add(post5);
        Arraypost3.add(post6);
        Arraypost1.add(post7);
        Arraypost1.add(post8);
        Arraypost2.add(post9);
        Arraypost3.add(post10);
        Seller sell1 = new Seller(1001,"Vendedor Pepito perez",Arraypost1,userAsigned1);
        Seller sell2 = new Seller(1002,"Vendedor Maria perez",Arraypost2,userAsigned2);
        Seller sell3 = new Seller(1003,"Vendedor Juan cans",Arraypost3,userAsigned3);
        Sellers.add(sell1);
        Sellers.add(sell2);
        Sellers.add(sell3);

    }

    //Seguir a un vendedor
    @Override
    public boolean Follow(int iduser, int id_vendedor) {

        UserDTO usuario1 = new UserDTO();
        for (int i = 0; i < UserDTO.size(); i++) {
            if(UserDTO.get(i).getUserId()==iduser){
                usuario1.setUserName(UserDTO.get(i).getUserName());
                usuario1.setUserId(UserDTO.get(i).getUserId());
            }
        }


        for (int i = 0; i < Sellers.size(); i++) {
            if(Sellers.get(i).getId()==id_vendedor){

                for (int j = 0; j < Sellers.get(i).getUsuarios().size(); j++) {
                    if(Sellers.get(i).getUsuarios().get(j).getUserId()==iduser){
                        return false;
                    }
                }
                if(usuario1.getUserName().isEmpty()){
                    return false;
                }else{
                    Sellers.get(i).getUsuarios().add(usuario1);
                    return true;
                }
            }
        }

        return true;

    }
//Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    public CountUser countUsers(int iduser){
        CountUser cantidad=  new CountUser();

        for (int i = 0; i < Sellers.size(); i++) {

            if(Sellers.get(i).getId()==iduser){
                cantidad.setUserid(Sellers.get(i).getId());
                cantidad.setUserName(Sellers.get(i).getNombre());
                cantidad.setFollowers_count(Sellers.get(i).getUsuarios().size());
            }
        }
        return cantidad;
    }
    //Obtenemos el vendedor correspondiente al iduser
    public Seller listUsers(int iduser){
        for (int i = 0; i < Sellers.size(); i++) {

            if(Sellers.get(i).getId()==iduser){

                return Sellers.get(i);
            }
        }
        return null;
    }
    //Obtenemos los vendedores que isgue un determinado comprador
    @Override
    public ListSeller listVendedores(int iduser) {
        ListSeller listVen =new ListSeller();

        ArrayList<SellerResponseDTO> vendedores= new ArrayList<>();

        for (int i = 0; i < UserDTO.size(); i++) {
            if(UserDTO.get(i).getUserId()==iduser){
                listVen.setUserId(UserDTO.get(i).getUserId());
                listVen.setUserName(UserDTO.get(i).getUserName());

                for (int j = 0; j < Sellers.size(); j++) {

                    for (int t = 0; t < Sellers.get(j).getUsuarios().size(); t++) {
                        if(Sellers.get(j).getUsuarios().get(t).getUserId()==iduser){

                            SellerResponseDTO vendedor = new SellerResponseDTO(Sellers.get(j).getId(),Sellers.get(j).getNombre());
                            vendedores.add(vendedor);

                        }
                    }
                }
            }
        }
        listVen.setFollowed(vendedores);
        return listVen;
    }
    // Añadimos la nueva publicaciòn
    @Override
    public boolean newPost(Post publi) {
        for (int i = 0; i < Sellers.size(); i++) {
            if(Sellers.get(i).getId()==publi.getUserId()){
                Sellers.get(i).getPublicacions().add(PostMapper.toDTO(publi));
                return true;
            }
        }
        return false;
    }
//Obtenemos las publicaciones por cada vendedor
    @Override
    public ListSellerPost getListPostVendedors(int iduser) {

        ListSellerPost response= new ListSellerPost();
        ArrayList<PostResponseDTO> post = new ArrayList<>();
        for (int i = 0; i < UserDTO.size(); i++) {
            if(UserDTO.get(i).getUserId()==iduser){
                response.setUserId(UserDTO.get(i).getUserId());
                for (int j = 0; j < Sellers.size(); j++) {
                    for (int t = 0; t < Sellers.get(j).getUsuarios().size(); t++) {
                        if(Sellers.get(j).getUsuarios().get(t).getUserId()==iduser){
                            for (int l = 0; l < Sellers.get(j).getPublicacions().size(); l++) {

                                post.add(PostMapper.toPostResponse(Sellers.get(j).getPublicacions().get(l)));
                            }
                        }
                    }

                }

            }

        }
        response.setPosts(post);

        return response;
    }
//Dejar de seguir a un vendedor
    @Override
    public boolean unFollow(int iduser, int id_vendedor) {
        UserDTO usuario1 = new UserDTO();
        for (int i = 0; i < UserDTO.size(); i++) {

            if(UserDTO.get(i).getUserId()==iduser){
                usuario1.setUserName(UserDTO.get(i).getUserName());
                usuario1.setUserId(UserDTO.get(i).getUserId());
            }
        }
        for (int i = 0; i < Sellers.size(); i++) {

            if(Sellers.get(i).getId()==id_vendedor){

                if(usuario1.getUserName().isEmpty()){
                    return false;
                }else{
                    Sellers.get(i).getUsuarios().remove(i);
                    return true;
                }
            }else{
                return false;

            }
        }

        return true;
    }
//Añadimos la nueva publicaciòn con descuento
    @Override
    public boolean newPostDiscount(Post publi) {
        for (int i = 0; i < Sellers.size(); i++) {
            if(Sellers.get(i).getId()==publi.getUserId()){
                Sellers.get(i).getPublicacions().add(PostMapper.toDTO(publi));
                return true;
            }
        }
        return false;
    }

    //Obtenemos el vendedor deacuerdo al id
    @Override
    public Seller getVendedor(int userId) {

        Seller vendedor = new Seller();
        for (int i = 0; i < Sellers.size(); i++) {
            if(Sellers.get(i).getId()==userId){
                vendedor= Sellers.get(i);

            }
        }
        return vendedor;
    }

}
