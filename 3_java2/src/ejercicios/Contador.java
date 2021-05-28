package ejercicios;
public class Contador {
//    Crea una clase Contador (sí, contador de programación) con métodos que permitan
//    incrementar y decrementar su valor.
//    la clase contendrá un constructor por defecto, un constructor con parámetros,
//    un constructor copia y los setters y getters (métodos de acceso) que corresponda.

    private int counter;

    public Contador(int number) {
        this.counter = number;
    }

    public Contador(Contador initial) {
        this.counter = initial.getContador();
    }

    public  Contador() {
        this.counter = 0;
    }

    public void incrementar(){
        this.counter++;
    }

    public void decrementar(){
        this.counter--;
    }

    public void setContador(int counter) {
        this.counter = counter;
    }

    public int getContador() {
        return this.counter;
    }
}
