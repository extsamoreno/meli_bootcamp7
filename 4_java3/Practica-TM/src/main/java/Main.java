public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("juan", 100);
        Persona persona2 = new Persona("juana", 101);
        Persona persona3 = new Persona("juano", 99);

        Precedable<Persona> []personas =new Precedable[3];
        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;

        SortUtil.ordenar(personas);
        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i].toString());
        }

        Celular celular1 = new Celular(1149176184, "juan");
        Celular celular2 = new Celular(1149176108, "juana");
        Celular celular3 = new Celular(1149176188, "juano");

        Precedable<Celular> []celulares =new Precedable[3];
        celulares[0] = celular1;
        celulares[1] = celular2;
        celulares[2] = celular3;

        SortUtil.ordenar(celulares);
        for (int i = 0; i < celulares.length; i++) {
            System.out.println(celulares[i].toString());
        }

    }
}
