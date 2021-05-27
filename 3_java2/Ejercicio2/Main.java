package Ejercicio2;

public class Main {
    //Pruebas ejercicio 2
    public static void main(String[] args) {
        Contador contador = new Contador();
        contador.incrementar(10);
        contador.incrementar();
        contador.decrementar(3);
        System.out.println(contador.toString());
    }
}
