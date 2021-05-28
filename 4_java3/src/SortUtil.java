public class SortUtil<T> {

    public static<T> void ordenar(Precedable<T> arr[]){
        T auxiliar ;

        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                Precedable a = arr[j+1];
                Precedable b = arr[j];
                int prueba = a.precedeAt(b);
                if (prueba == -1 ){
                    auxiliar = (T) arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = (Precedable<T>) auxiliar;

                }
            }

        }
    }

    public static void main(String[] args) {
        //SortUtil<Persona> util = new SortUtil<Persona>();

        Persona persona1 = new Persona("Nombre A", 13);
        Persona persona2 = new Persona("Nombre B", 1);
        Persona persona3 = new Persona("Nombre C", 56);
        Persona persona4 = new Persona("Nombre D", 39);
        Persona persona5 = new Persona("Nombre E", 4);

        Precedable<Persona>[] arr = new Precedable[5];

        arr[0] = persona1;
        arr[1] = persona2;
        arr[2] = persona3;
        arr[3] = persona4;
        arr[4] = persona5;

        //util.ordenar(arr);

        Celular celular1 = new Celular(312545,"Titular A");
        Celular celular2 = new Celular(456447,"Titular B");
        Celular celular3 = new Celular(123556,"Titular C");
        Celular celular4 = new Celular(790744,"Titular D");
        Celular celular5 = new Celular(945345,"Titular E");

        Precedable<Celular>[] arr2 = new Precedable[5];
        arr2[0] = celular1;
        arr2[1] = celular2;
        arr2[2] = celular3;
        arr2[3] = celular4;
        arr2[4] = celular5;

        //SortUtil<Celular> util2 = new SortUtil<Celular>();

        //util2.ordenar(arr2);

        SortUtil.ordenar(arr);
        SortUtil.ordenar(arr2);

        for (int i = 0; i <arr.length ; i++) {
            Persona generica = (Persona) arr[i];
            System.out.println(generica.getNombre());
        }

        for (int i = 0; i <arr.length ; i++) {
            Celular generica = (Celular) arr2[i];
            System.out.println(generica.getTitular());
        }



    }
}
