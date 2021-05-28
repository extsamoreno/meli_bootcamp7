package ej1;


public class Main {
  public static void main(String[] args) {
    Persona personasLindas[] = new Persona [3];
    personasLindas[0] = new Persona("Jhader", 2819210);
    personasLindas[1] = new Persona("Luz", 238149102);
    personasLindas[2] = new Persona("Marcos", 3728191);

    System.out.println("Arreglo desordenado");
    for (Persona p : personasLindas)
    System.out.println(p.getDni());


    SortUtil.ordenar(personasLindas);
    System.out.println("Arreglo ordenado");
    for (Persona p : personasLindas)
      System.out.println(p.getDni());


  }
}
