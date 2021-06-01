package ejercicio3;

public class FuegoArtificialIndividual implements FuegoArtificial {

    private String tipoRuido;
    private static int contador = 1;

    public FuegoArtificialIndividual() {
        generarRuido();
    }

    @Override
    public void accionar() {
        System.out.println(tipoRuido);
    }

    public void generarRuido() {

        String letra = "o";
        contador++;

        tipoRuido = "b" + letra.repeat(contador) + "m";
    }

    public String getTipoRuido() {
        return tipoRuido;
    }

    public void setTipoRuido(String tipoRuido) {
        this.tipoRuido = tipoRuido;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        FuegoArtificialIndividual.contador = contador;
    }
}
