package bootcamp;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	// write your code here
        Persona pa = new Persona("matias", 33654878, 17);
        Persona pb = new Persona("Leandro", 35644878, 34);
        Persona pc = new Persona("Alexis", 35644878, 17);
        Persona pd = new Persona("Matias2", 35644878, 24);

        Celular ca, cb, cc, cd;
        ca = new Celular(1234, pa);
        cb = new Celular(5678, pb);
        cc= new Celular(9879, pd);
        cd = new Celular(2584, pd);

        Persona[] arr = {pa, pb, pc, pd};
        Celular[] arr2 = {ca, cb, cc, cd};

        int a = pb.precedeA(pa);
        System.out.println("a = " + a);

        SortUtil.ordenar(arr);

        for( Persona x: arr){
            System.out.print("nombre = " + x.getNombre());
            System.out.println("edad= " + x.getEdad());
        }

        SortUtil.ordenar(arr2);

        for( Celular x: arr2){
            System.out.print("Titular = " + x.getTitular().getNombre());
            System.out.println("Num cel = " + x.getNumero());
        }

    }


    /* A utility function to print array of size n */
    public static <T> void printArray(T[] arr)
    {
        for(T num: arr)
            System.out.print(num+",  ");
        System.out.println();
    }
}

