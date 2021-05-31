package bootcamp;

public class FuegoArtificial implements FuegoArtificialI {

    private String ruido;

    public FuegoArtificial(String ruido) {
        this.ruido = ruido;
    }

    public void explotar(){
        System.out.println(this.ruido + "!!!");
    }
}
