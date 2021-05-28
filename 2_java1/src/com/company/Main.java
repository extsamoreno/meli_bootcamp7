package com.company;

public class Main {

    public static void main(String[] args) {
        Ej1 ej1 = new Ej1();
        Ej2 ej2 = new Ej2();
        Ej3 ej3 = new Ej3();
        Ej4 ej4 = new Ej4();
        Ej5 ej5 = new Ej5();

        ej1.pares();
        ej2.divisible();
        ej3.ej3();
        ej4.mostrarPrimos();
        ej5.mostrarNaturales();

        /*int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }*/
    }
}
