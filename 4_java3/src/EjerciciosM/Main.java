package EjerciciosM;

public class Main {

    public static void main(String[] args) {

        Persona[] arrPersonas = new Persona[]{

                new Persona("Juan", 38123321),
                new Persona("Franco", 40123321),
                new Persona("Mariano", 2124321),
                new Persona("Ana", 32123321)
        };

        SortUtil.ordenar(arrPersonas, 0);
        System.out.println("PERSONAS y DNI");

        for(var p : arrPersonas){

            System.out.println("nombre:" + p.getNombre() + " dni: " + p.getDni());
        }

        Celular[] arrCelular = new Celular[]{

                new Celular("Juan", 2),
                new Celular("Marcelo", 6),
                new Celular("Maria", 20),
                new Celular("Tomas", 1),
                new Celular("Bruno", 3)
        };

        System.out.println("CELULARES");
        SortUtil.ordenar(arrCelular, 1);

        for(var c : arrCelular){

            System.out.println("nombre: " + c.getTitular() + " numero: " + c.getNumero());
        }
    }
}
