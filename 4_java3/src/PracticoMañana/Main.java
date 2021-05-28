package PracticoMañana;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona(38295252,"Matias");
        Persona p2 = new Persona(38295251,"Eduardo");
        Persona p3 = new Persona(38295253,"Franco");

        Persona[] arr = {p1, p2, p3};

        Celular c1 = new Celular(2223, p1);
        Celular c2 = new Celular(3332, p3);
        Celular c3 = new Celular(2212, p2);

        Celular[] arr2 = {c1, c2, c3};

        SortUtil.ordenar(arr);
        SortUtil.ordenar(arr2);

        for(Persona persona : arr){
            System.out.println(persona.getNombre() + " - " + persona.getDni());
        }

        for(Celular celular : arr2){
            System.out.println(celular.getNumero() + " - " + celular.getTitular().getNombre());
        }
    }
}
