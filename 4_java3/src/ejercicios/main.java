package ejercicios;

public class main {
    public static void main(String[] args) {
        Precedable <Persona> arr[] = new Precedable[3];
        arr[0]=new Persona("Mariano",71323445);
        arr[1]=new Persona("Pedro",94536789);
        arr[2]=new Persona("Maria",24516723);

        System.out.println("///////////////////////////////////");
        System.out.println("Prueba Personas:");
        System.out.println("///////////////////////////////////");
        System.out.println("Array sin ordenar");

        System.out.println( arr[0]);
        System.out.println( arr[1]);
        System.out.println( arr[2]);

        SortUtil.ordenar(arr);

        System.out.println("Array ordenado");

        System.out.println( arr[0]);
        System.out.println( arr[1]);
        System.out.println( arr[2]);

        Precedable <Celular> arrC[] = new Precedable[3];

        arrC[0]=new Celular("Joaquin",15333666);
        arrC[1]=new Celular("Ines",15777333);
        arrC[2]=new Celular("Yesica",15366123);

        System.out.println("///////////////////////////////////");
        System.out.println("Prueba Celulares:");
        System.out.println("///////////////////////////////////");
        System.out.println("Array sin ordenar");

        System.out.println( arrC[0]);
        System.out.println( arrC[1]);
        System.out.println( arrC[2]);

        SortUtil.ordenar(arrC);

        System.out.println("Array ordenado");

        System.out.println( arrC[0]);
        System.out.println( arrC[1]);
        System.out.println( arrC[2]);

    }
}
