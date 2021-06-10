package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.Exception.SeguidorYaRegistradoException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
import com.socialmeli.desafio.service.ISocialService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Data
public class InitRepository implements IInitRepository{

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IVendedorRepository iVendedorRepository;

    @Autowired
    ISocialService iSocialService;


    //Aca se van a llamar a los metodos que van a dar de alta una base de datos de prueba
   public void altaUsuarios(){


       iUserRepository.altaUsuario("Usuario 1");
       iUserRepository.altaUsuario("Usuario 2");
       iUserRepository.altaUsuario("Usuario 3");
       iUserRepository.altaUsuario("Usuario 4");
       iUserRepository.altaUsuario("Usuario 5");
       iUserRepository.altaUsuario("Usuario 6");
       iUserRepository.altaUsuario("Usuario 7");


    }

    @Override
    public void altaVendedores() {
        iVendedorRepository.altaVendedor("Vendedor 1");
        iVendedorRepository.altaVendedor("Vendedor 2");
        iVendedorRepository.altaVendedor("Vendedor 3");
        iVendedorRepository.altaVendedor("Vendedor 4");
        iVendedorRepository.altaVendedor("Vendedor 5");
        iVendedorRepository.altaVendedor("Vendedor 6");
        iVendedorRepository.altaVendedor("Vendedor 7");
    }


    public void follow() throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorYaRegistradoException {

        iSocialService.follow(2, 2);
        iSocialService.follow(2, 3);
        iSocialService.follow(1, 1);
        iSocialService.follow(3, 5);
        iSocialService.follow(2, 1);
        iSocialService.follow(3, 1);
        iSocialService.follow(3, 3);

        }



    /*public void createPost() {

        Date fecha1= new Date();
        fecha1= arreglarFecha("2021-04-29 00:00:00");
        System.out.println(fecha1.toString());

        Date fecha2= new Date();
        fecha1= arreglarFecha("2021-06-08 13:29:00");
        System.out.println(fecha1.toString());

        Date fecha3= new Date();
        fecha1= arreglarFecha("2021-06-07 00:00:00");
        System.out.println(fecha1.toString());

        DetailModel details1= new DetailModel(1,"MESA","Gamer","Racer","Red and Black","EspecialEdition");
       // DetailModel details2= new DetailModel(62,"GORRO","Gamer","Racer","Green with RGB","Sin bateria");
       iSocialService.createPost(new PublicacionModel(1,1,fecha2,details1,100,1500.50));
       //iSocialService.createPost(new PublicacionModel(2,2,fecha2,details1,100,1800.50));
      // iSocialService.createPost(new PublicacionModel(2,3,fecha3,details2,100,1900.50));


    }

    public Date arreglarFecha(String s){
       Date fecha= null;

       try{
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           fecha = dateFormat.parse(s);
       }
       catch (Exception e){

       }
        return fecha;
    }

*/








}
