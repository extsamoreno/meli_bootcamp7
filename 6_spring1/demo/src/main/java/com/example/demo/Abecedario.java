package com.example.demo;

public class Abecedario extends Lenguaje {
    private String frase;

    public Abecedario(String frase) {
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
        StringBuilder codificado = new StringBuilder();
        for (int i = 0; i < this.frase.length(); i++) {
            String charComoCadenaYEnMayusculas = String.valueOf(this.frase.charAt(i)).toUpperCase();
            String equivalencia = asciiAMorse(charComoCadenaYEnMayusculas);
            codificado
                    .append(equivalencia)
                    .append(" ");
        }
        return codificado.toString();
    }
}
