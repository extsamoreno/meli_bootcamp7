package TM;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Pepe", 3);
        Persona persona2 = new Persona("Juan", 2);
        Persona persona3 = new Persona("Esteban", 1);
        Persona persona4 = new Persona("Jose", 0);

        Persona[] personas = new Persona[]{persona1,persona2,persona3,persona4};


        Celular celular1 = new Celular("Pepe", 3);
        Celular celular2 = new Celular("Juan", 1);
        Celular celular3 = new Celular("Esteban", 2);
        Celular celular4 = new Celular("Jose", 0);

        Celular[] celulares = new Celular[]{celular1, celular2, celular3, celular4};

        SortUtil.ordenar(personas);
        SortUtil.ordenar(celulares);

        System.out.println("TM.Persona 0, Dni:\n" + personas[0].getDni());
        System.out.println("TM.Persona 1, Dni:\n" + personas[1].getDni());
        System.out.println("TM.Persona 2, Dni:\n" + personas[2].getDni());
        System.out.println("TM.Persona 3, Dni:\n" + personas[3].getDni());

        System.out.println("Titular 0, numero:\n" + celulares[0].getNumero());
        System.out.println("Titular 1, numero:\n" + celulares[1].getNumero());
        System.out.println("Titular 2, numero:\n" + celulares[2].getNumero());
        System.out.println("Titular 3, numero:\n" + celulares[3].getNumero());
    }
}
