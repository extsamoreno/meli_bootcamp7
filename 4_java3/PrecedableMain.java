public class PrecedableMain {

    public static void main(String[] args) {
        Precedable<Persona> persona1 = new Persona("Juan",00000002);
        Precedable<Persona> persona2 = new Persona("Pepe",00000001);
        Precedable<Persona> persona3 = new Persona("Mario",00000003);

        Precedable[] precedables = {persona1,persona2,persona3};

        SortUtil.ordenar(precedables);

        Precedable<Celular> cel1 = new Celular( 234912,"Jorge");
        Precedable<Celular> cel2 = new Celular(123456,"Maria");
        Precedable<Celular> cel3 = new Celular(129304,"Rober");

        Precedable[] precedables2 = {cel1,cel2,cel3};

        SortUtil.ordenar(precedables2);

        for (int i = 0; i < 3; i++) {
            System.out.println(precedables[i]);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(precedables2[i]);
        }

    }
}
