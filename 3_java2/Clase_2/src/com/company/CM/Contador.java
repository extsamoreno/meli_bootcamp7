package com.company.CM;


/*Crea una clase Contador (sí, contador de programación) con métodos que permitan incrementar y decrementar su valor.
La clase contendrá un constructor por defecto, un constructor con parámetros, un constructor copia y los setters y getters (métodos de acceso) que corresponda.*/
public class Contador {

    private int contador;


    public Contador(Contador contador) {
        this.contador = contador.getContador();
    }
    public Contador(int contador) {
        this.contador = contador;
    }

    public Contador() {
        this.contador=1;
    }

    public  void incrementar(){
        this.contador++;

    }
    public  void incrementar(int valor){
        this.contador=this.contador+valor;

    }
    public void decrementar(){
        this.contador--;

    }
    public void decrementar(int valor){
        this.contador=this.contador-valor;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
