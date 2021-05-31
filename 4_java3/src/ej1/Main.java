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
    Celular []celulares = {
      new Celular("Luz", 2819210),
      new Celular("Jhader", 238149102),
      new Celular("Marcos", 3728191)};

    System.out.println("Arreglo desordenado de celulares: ");
    muestraArray(celulares);
    System.out.println("-------------------------------------");

    SortUtil.ordenar(celulares);
    System.out.println("Arreglo ordenado por titular: ");
    muestraArray(celulares);
    System.out.println("-------------------------------------");
  }
  private static void muestraArray(Precedable arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
