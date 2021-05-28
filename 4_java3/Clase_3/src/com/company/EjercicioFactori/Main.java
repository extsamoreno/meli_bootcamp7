package com.company.EjercicioFactori;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Telegrafo o1 = new Telegrafo();
        o1.enviarMensaje("Hola 1");

        TelefonoCelular o2 = new TelefonoCelular();
        o2.enviarMensaje("Hola 2");

        PalomaMensajera o3 = new PalomaMensajera();
        o3.enviarMensaje("Hola 3");

        Comunicador o4 = new TelefonoCelular();
        o4.enviarMensaje("Hola 4");

        Comunicador o5 = ComunicadorFactory.crearComunicador();
        o5.enviarMensaje("Hola 5");

        Comunicador o6 = ComunicadorFactory.crearComunicador(1);
        o6.enviarMensaje("Hola 6");

        Comunicador o7 = ComunicadorFactory.crearComunicador(2);
        o7.enviarMensaje("Hola 7");

        Comunicador o8 = ComunicadorFactory.crearComunicador(3);
        o8.enviarMensaje("Hola 8");

        Comunicador o9 = ComunicadorFactory.crearComunicador(new Telegrafo());
        o9.enviarMensaje("Hola 9");

        Comunicador o10 = ComunicadorFactory.crearComunicador(new PalomaMensajera());
        o10.enviarMensaje("Hola 10");

        Comunicador o11 = ComunicadorFactory.crearComunicador(new TelefonoCelular());
        o11.enviarMensaje("Hola 11");

    }

}
