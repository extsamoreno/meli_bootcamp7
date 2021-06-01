package Excercise3;

public class FuergoArtNormal implements FuegosArtificiales {

    private String ruido;

    public FuergoArtNormal(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public void explotar() {
        System.out.println("hice: " + ruido);
    }
}
