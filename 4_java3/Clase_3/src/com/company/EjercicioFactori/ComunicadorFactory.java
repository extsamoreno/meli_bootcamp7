package com.company.EjercicioFactori;

public class ComunicadorFactory {

    public static Comunicador crearComunicador(){
        return new PalomaMensajera();
    }

    public static Comunicador crearComunicador(int tipo){
        switch (tipo){
            case 1:{
                return new PalomaMensajera();
            }
            case 2:{
                return new TelefonoCelular();
            }
            case 3:{
                return new Telegrafo();
            }
        }
        return new PalomaMensajera();
    }

    public static <T> Comunicador crearComunicador(T t){
        return new Comunicador() {
            @Override
            public void enviarMensaje(String mns) {
                ((Comunicador)t).enviarMensaje(mns);
            }
        };
    }

}
