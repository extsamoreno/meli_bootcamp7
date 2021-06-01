package Excercise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op = 0;


        List<Prenda> lista = new ArrayList<Prenda>();
        Scanner sc = new Scanner(System.in);
        GuardaRopa guardaRopa = new GuardaRopa() {
        };
        do {
            System.out.println("Elija una opción");
            System.out.println("1- Agregar Prenda");
            System.out.println("2- Guardar Prendas");
            System.out.println("3- Mostrar Prendas");
            System.out.println("4- Devolver Prendas");
            System.out.println("5- Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese la Marca de la prenda");
                    String marca = sc.next();
                    System.out.println("Ingrese el Modelo de la prenda");
                    String modelo = sc.next();
                    Prenda prenda = new Prenda(marca, modelo) {
                    };
                    lista.add(prenda);
                    break;
                case 2:
                    if (lista.size() != 0) {
                        System.out.println("Sus prendas quedaron guardadas con el código: " + guardaRopa.guardarPrendas(lista));
                        lista= new ArrayList<Prenda>();
                    } else {
                        System.out.println("La lista no debe estar vacía");
                    }
                    break;
                case 3:
                    guardaRopa.mostrarPrendas();
                    break;
                case 4:
                    System.out.println("Ingrese el código del guardaropa");
                    int cod = sc.nextInt();
                    List<Prenda> listaPrendas = guardaRopa.devolverPrendas(cod);

                    for (Prenda se : listaPrendas) {
                        System.out.println("    Marca: " + se.getMarca() + " Modelo: " + se.getModelo());
                    }
                    break;
            }
        } while (op != 5);
        System.out.println("Presione enter para salir");
        sc.next();
        sc.close();
    }


}
