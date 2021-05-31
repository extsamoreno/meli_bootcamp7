package com.company.ej3;

public class FuegoArtificial implements Component{

    private String sonido;

    public FuegoArtificial(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public void explotar() {
        System.out.println(sonido);
    }
}
