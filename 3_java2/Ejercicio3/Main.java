package Ejercicio3;

public class Main {
    //Pruebas ejercicio 3
    public static void main(String[] args) {
        Libro l1 = new Libro( "La hojarasca","234877","Gabriel Garcia Marquez", false);
        System.out.println(l1.toString());
        Libro.prestamo(l1);
        System.out.println(l1.toString());
    }
}
