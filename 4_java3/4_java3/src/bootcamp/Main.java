package bootcamp;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Sorter sorter = new QuickSortSorterImple();
        Integer[] arr = {5, 6, 19, 8, 9,89};
        Comparator<Integer> c1 = (a, b)->a-b;
        sorter.sort(arr, c1);

        mostrarArreglo(arr);

//        System.out.println("arr = " + arr.toString());
        
        
//        Persona pa = new Persona("matias", 33654878, 17);
//        Persona pb = new Persona("Leandro", 35644878, 34);
//        Persona pc = new Persona("Alexis", 35644878, 17);
//        Persona pd = new Persona("Matias2", 35644878, 24);
//
//        Celular ca, cb, cc, cd;
//        ca = new Celular(1234, pa);
//        cb = new Celular(5678, pb);
//        cc= new Celular(9879, pd);
//        cd = new Celular(2584, pd);
//
//        Persona[] arr = {pa, pb, pc, pd};
//        Celular[] arr2 = {ca, cb, cc, cd};
//        
//        int a = pb.precedeA(pa);
//        System.out.println("a = " + a);
//        
//        SortUtil.ordenar(arr);
//
//        for( Persona x: arr){
//            System.out.print("nombre = " + x.getNombre());
//            System.out.println("edad= " + x.getEdad());
//        }
//
//        SortUtil.ordenar(arr2);
//
//        for( Celular x: arr2){
//            System.out.print("Titular = " + x.getTitular().getNombre());
//            System.out.println("Num cel = " + x.getNumero());
//        }
//        
    }

    private static <T>void mostrarArreglo(T[] arr) {
        System.out.println("");
        for(T num: arr)
            System.out.print(num+" ");
    }
}

