package com.bootcamp;

public class FuegoArtNormal implements FuegoArtificial {

    private String ruido;

    public FuegoArtNormal(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public void explotar() {
        System.out.println("Hago el ruido: " + ruido);
    }


}
