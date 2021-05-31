package com.ejercitacion.m.tercero;

public class FuegoArtificial {

    public String ruido;

    public FuegoArtificial(String ruido) {
        this.ruido = ruido;
    }

    public FuegoArtificial() {
    }

    public void explotar() {
        System.out.println(ruido);
    }

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }
}
