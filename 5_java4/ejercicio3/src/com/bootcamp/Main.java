package com.bootcamp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Fuegos artificiales
        ArrayList<FuegoArtificial> arr = new ArrayList<>() {{
            add(new FuegoArtNormal("adfjsadiuni1"));
            add(new FuegoArtNormal("ashuuuuu"));
        }};

        FuegoArtificial pack1 = new FuegoPack(arr);

        ArrayList<FuegoArtificial> arr2 = new ArrayList<>() {{
            add(new FuegoArtNormal("pika"));
            add(new FuegoArtNormal("pika1"));
            add(pack1);
        }};

        FuegoArtificial pack2 = new FuegoPack(arr2);

        ArrayList<FuegoArtificial> arrFinal = new ArrayList<>() {{
            add(new FuegoArtNormal("adfjsadiuni1"));
            add(new FuegoArtNormal("ashuuuuu"));
            add(pack1);
            add(pack2);
        }};

        //INVITADOS
        ArrayList<Invitado> arrInv = new ArrayList<>(){{
            add(new Invitado("Empleado que no es de MeLi"));
            add(new InvitadoMeli("Este si es de MeLi"));
        }};

        Evento laFiestaDeLaChiqui = new Evento(arrInv, arrFinal);
        laFiestaDeLaChiqui.apagarVelas();
    }
}
