package contador;
/*Crea una clase contador.Contador con métodos que permitan incrementar y decrementar su valor.
La clase contendrá un constructor por defecto, un constructor con parámetros,
un constructor copia y los setters y getters (métodos de acceso) que corresponda.
 */

public class Contador {
    private int contador;

    //constructor por defecto
    public Contador() {}

    //constructor por parámetros
    public Contador(int contador) {
        if (contador < 0) {
            this.contador = 0;
        } else {
            this.contador = contador;
        }
    }

    //constructor copia
    public Contador(Contador c) {
        this(c.contador);
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        if (contador < 0) {
            this.contador = 0;
        } else {
            this.contador = contador;
        }
    }

    public void incrementar() {
        contador++;
    }

    public void decrementar() {
        contador--;
        if (contador < 0) {
            contador = 0;
        }
    }

}


