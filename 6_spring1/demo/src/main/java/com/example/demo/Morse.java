package com.example.demo;

public class Morse extends  Lenguaje{
    private String frase;

    public Morse(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    public String decodificacion(){
        StringBuilder decodificado = new StringBuilder();
        // Necesitamos separarlo por espacios
        String[] morse = this.frase.split(" ");
        for (String morseActual : morse) {
            // Armo la palabra
            String equivalencia = morseAAscii(morseActual);
            decodificado.append(equivalencia);
        }
        return decodificado.toString();
    }
}
