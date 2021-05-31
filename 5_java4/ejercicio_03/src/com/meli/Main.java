package com.meli;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //FUEGOS ARTIFICIALES
        FuegoArtificial explo1= new FuegoArtIndividual("adfjsadiuni1");
        FuegoArtificial explo2= new FuegoArtIndividual("ashuuuuu");
        FuegoArtificial explo3= new FuegoArtIndividual("pika");
        FuegoArtificial explo4= new FuegoArtIndividual("pika1");

        ArrayList<FuegoArtificial> arr= new ArrayList<>();
        arr.add(explo1);
        arr.add(explo2);
        FuegoArtificial pack1= new FuegoArtPack(arr);

        ArrayList<FuegoArtificial> arr2= new ArrayList<>();
        arr2.add(explo3);
        arr2.add(explo4);
        arr2.add(pack1);
        FuegoArtificial pack2= new FuegoArtPack(arr2);

        ArrayList<FuegoArtificial> arrFinal= new ArrayList<>();
        arrFinal.add(explo1);
        arrFinal.add(explo4);
        arrFinal.add(pack2);
        arrFinal.add(pack1);

        //INVITADOS
        ArrayList<Invitado> arrInv= new ArrayList<>();
        Invitado inv= new Invitado("Invitado Standar");
        Invitado inv2= new InvitadoMeli("Invitado Meli");
        arrInv.add(inv);
        arrInv.add(inv2);

        Evento laFiestaDeLaChiqui= new Evento(arrInv,arrFinal);
        laFiestaDeLaChiqui.apagarVelas();
    }
}
