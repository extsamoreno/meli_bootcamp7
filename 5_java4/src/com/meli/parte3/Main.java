package com.meli.parte3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FuegoArtificial explo1= new FuegoArtNormal("adfjsadiuni1");
        FuegoArtificial explo2= new FuegoArtNormal("ashuuuuu");
        FuegoArtificial explo3= new FuegoArtNormal("pika");
        FuegoArtificial explo4= new FuegoArtNormal("pika1");


        ArrayList<FuegoArtificial> arr= new ArrayList<>();
        arr.add(explo1);
        arr.add(explo2);
        FuegoArtificial pack1= new FuegoPack(arr);

        ArrayList<FuegoArtificial> arr2= new ArrayList<>();
        arr2.add(explo3);
        arr2.add(explo4);
        arr2.add(pack1);
        FuegoArtificial pack2= new FuegoPack(arr2);

        ArrayList<FuegoArtificial> arrFinal= new ArrayList<>();
        arrFinal.add(explo1);
        arrFinal.add(explo4);
        arrFinal.add(pack2);
        arrFinal.add(pack1);

        //INVITADOS
        ArrayList<Invitado> arrInv= new ArrayList<>();
        Invitado inv= new Invitado("empleado que no es de meli");
        Invitado inv2= new InvitadoMeli("este si es de meli");
        arrInv.add(inv);
        arrInv.add(inv2);

        Evento laFiestaDeLaChiqui= new Evento(arrInv,arrFinal);
        laFiestaDeLaChiqui.apagarVelas();


    }
}
