package tm;

public class Main {

    public static void main(String[] args) {
        Persona personas[] = new Persona[3];
        personas[0] = new Persona("Jhader", 2819210);
        personas[1] = new Persona("Luz", 238149102);
        personas[2] = new Persona("Marcos", 3728191);

        // Personas
        System.out.print("Arreglo de entrada : ");
        for (Persona p : personas) {
            System.out.print(p.getDni() + " ");
        }
        System.out.println();

        SortUtil.ordenar(personas);
        System.out.print("Arreglo ordenado por numero de DNI: ");
        for (Persona p : personas) {
            System.out.print(p.getDni() + " ");
        }
        System.out.println();

        Celular celulares[] = new Celular[3];
        celulares[0] = new Celular("Marcos", 2819210);
        celulares[1] = new Celular("Luz", 238149102);
        celulares[2] = new Celular("Jhader", 3728191);

        // Personas
        System.out.print("Arreglo de entrada : ");
        for (Celular c : celulares) {
            System.out.print(c.getTitular() + " ");
        }
        System.out.println();
        SortUtil.ordenar(celulares);
        System.out.print("Arreglo ordenado por numero de DNI: ");
        for (Celular c : celulares) {
            System.out.print(c.getTitular() + " ");
        }
    }

}
