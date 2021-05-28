package Ex1;

public class Main {
    public static void main(String[] args) {
        Persona[] arrPersonas = new Persona[]{
                new Persona("Juan", 12),
                new Persona("Maria", 1),
                new Persona("Pepe", 27),
                new Persona("Candela", 5)
        };

        for (var pers : arrPersonas) {
            System.out.println("nombre: " + pers.getNombre() + " dni: " + pers.getDni());
        }
        System.out.println("luego de ordenar...");
        SortUtil.ordenar(arrPersonas);

        for (var pers : arrPersonas) {
            System.out.println("nombre: " + pers.getNombre() + " dni: " + pers.getDni());
        }
        System.out.println("");

        Celular[] arrCelulares = new Celular[]{
                new Celular(123, "juanita"),
                new Celular(444, "pedro"),
                new Celular(999, "maria"),
                new Celular(543, "pepe")
        };

        for (var cel : arrCelulares) {
            System.out.println("numero: " + cel.getNumber() + " titular: " + cel.getName());
        }
        SortUtil.ordenar(arrCelulares);
        System.out.println("luego de ordenar");
        for (var cel : arrCelulares) {
            System.out.println("numero: " + cel.getNumber() + " titular: " + cel.getName());
        }

    }
}
