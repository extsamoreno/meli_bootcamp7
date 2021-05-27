public class Contador {
    /*Crea una clase Contador (sí, contador de programación) con métodos que permitan incrementar y decrementar su valor.
    La clase contendrá un constructor por defecto,
    un constructor con parámetros, un constructor copia y los setters y getters (métodos de acceso) que corresponda.
     */

    private int contador;

    public Contador(){

    }
    public Contador(int valorOrigen){
        this.contador = valorOrigen;
    }

    public Contador(Contador contador){
        this.contador = contador.contador;
    }

    public void incrementar (){
        this.contador++;
    }

    public void decrementar (){
        this.contador--;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
