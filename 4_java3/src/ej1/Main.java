package ej1;


public class Main {
  public static void main(String[] args) {
    Persona personasLindas[] = new Persona [3];
    personasLindas[0] = new Persona("Jhader", 2819210);
    personasLindas[1] = new Persona("Luz", 238149102);
    personasLindas[2] = new Persona("Marcos", 3728191);

    // Personas
    System.out.println("Arreglo desordenado de personas: ");
    for (Persona p : personasLindas)
      System.out.println(p);
    System.out.println("-------------------------------------");

    SortUtil.ordenar(personasLindas);
    System.out.println("Arreglo ordenado por numero de DNI: ");
    for (Persona p : personasLindas)
      System.out.println(p);
    System.out.println("-------------------------------------");

    // Celulares
    Celular []celulares = new Celular [3];
    celulares[0] = new Celular("Luz", 2819210);
    celulares[1] = new Celular("Jhader", 238149102);
    celulares[2] = new Celular("Marcos", 3728191);

    System.out.println("Arreglo desordenado de celulares: ");
    for (Celular c : celulares)
      System.out.println(c);
    System.out.println("-------------------------------------");

    SortUtil.ordenar(celulares);
    System.out.println("Arreglo ordenado por titular: ");
    for (Celular c : celulares)
      System.out.println(c);
    System.out.println("-------------------------------------");
  }
}
