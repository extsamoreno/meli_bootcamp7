package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Camilo",1014275527);
        Persona persona1 = new Persona("Stefania", 1233892899);
        Persona persona2 = new Persona("Susana", 51908587);
        Persona persona3 = new Persona("Andrea", 80321960);
        Persona persona4 = new Persona("Susana", 50908587);


        Persona[] array = { persona1,persona,persona3,persona4,persona2};
        SortUtil.ordenar(array);
        for (int i = 0; i<array.length;i++) {
            System.out.println(array[i].getNombre());
            System.out.println(array[i].getDni());
        }
        System.out.println();

        Celular celular = new Celular(312474640,"Stefania");
        Celular celular1 = new Celular(301770343, "Camilo");
        Celular celular2 = new Celular(324643312, "Susana");
        Celular[] array2 = {celular,celular1,celular2};
        SortUtil.ordenar(array2);
        for (int i = 0; i<array2.length;i++) {
            System.out.printf("%.0f \n",array2[i].getNumero());
            System.out.println(array2[i].getTitular());
        }



    }
}
