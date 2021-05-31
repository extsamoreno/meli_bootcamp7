package com.meli3;

public class FuegoArtificial implements Pirotecnia {
    private static int contador = 1;
    private String sonido;

    public FuegoArtificial() {
        String letra = "O";
        this.sonido = "B" + letra.repeat(contador) + "M!!!";
        FuegoArtificial.contador++;
    }

    @Override
    public void accionar() {
        System.out.println(this.getSonido());
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        FuegoArtificial.contador = contador;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
}
