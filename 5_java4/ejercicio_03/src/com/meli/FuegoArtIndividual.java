package com.meli;

public class FuegoArtIndividual implements FuegoArtificial {
    private String ruido;

    public FuegoArtIndividual(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public void explotar() {
        System.out.println("Fuego artificial: " + ruido);
    }
}
