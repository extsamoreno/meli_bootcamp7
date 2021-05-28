public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[5];
        personas[0] = new Persona("p1", 2);
        personas[1] = new Persona("p2", 3);
        personas[2] = new Persona("p3", 9);
        personas[3] = new Persona("p4", 1);
        personas[4] = new Persona("p5", 7);

        for (Persona p : personas) {
            System.out.print(p.getDni() + ", ");
        }
        System.out.println();
        SortUtil.ordenar(personas);
        for (Persona p : personas) {
            System.out.print(p.getDni() + ", ");
        }

        Celular[] celulares = new Celular[5];
        celulares[0] = new Celular("12");
        celulares[1] = new Celular("54");
        celulares[2] = new Celular("91");
        celulares[3] = new Celular("1");
        celulares[4] = new Celular("07");

        System.out.println();
        for (Celular c : celulares) {
            System.out.print(c.getNumero() + ", ");
        }
        System.out.println();
        SortUtil.ordenar(celulares);
        for (Celular c : celulares) {
            System.out.print(c.getNumero() + ", ");
        }
    }
}
