package Excercise3;

import java.util.ArrayList;

public class Main {

    //reventar Todos los artificiales

    //repartir torta

    public static void main(String[] args) {

        FuegosArtificiales explo1 = new FuergoArtNormal("Hola1");
        FuegosArtificiales explo2 = new FuergoArtNormal("Hola2");
        FuegosArtificiales explo3 = new FuergoArtNormal("Hola3");
        FuegosArtificiales explo4 = new FuergoArtNormal("Hola4");

        ArrayList<FuegosArtificiales> arr = new ArrayList<>();
        arr.add(explo1);
        arr.add(explo2);
        FuegosArtificiales pack1 = new FuegoPack(arr);

        ArrayList<FuegosArtificiales> arr2 = new ArrayList<>();
        arr2.add(explo3);
        arr2.add(explo4);
        arr2.add(pack1);
        FuegosArtificiales pack2 = new FuegoPack(arr2);

        ArrayList<FuegosArtificiales> arrFinal = new ArrayList<>();
        arrFinal.add(explo1);
        arrFinal.add(explo4);
        arrFinal.add(pack2);
        arrFinal.add(pack1);
        //INVITADOS
        ArrayList<Invitados> arrInv = new ArrayList<>();
        Invitados inv = new Invitados("empleado que no es de meli");
        InvitadosMeli inv2 = new InvitadosMeli("este si es de meli");
        arrInv.add(inv);
        arrInv.add(inv2);

        Evento laFiestaDeLaChiqui = new Evento(arrInv, arrFinal);
        laFiestaDeLaChiqui.apagarVelas();
    }


}
