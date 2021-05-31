package ejercicio3;

public class Timer {
    private long tiempoInicial;
    private long tiempoFinal;
    public void comenzar() {
        tiempoInicial = System.currentTimeMillis();
    }

    public void parar() {
        tiempoFinal = System.currentTimeMillis();
    }

    public String tiempoTranscurrido() {
        long diff = tiempoFinal-tiempoInicial;
        return Long.toString(diff/1000)+" segundos";
    }

}