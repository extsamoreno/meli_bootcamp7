package src.parte1;

import src.parte1.Clases.Celular;
import src.parte1.Clases.Persona;
import src.parte1.Interface.Precedable;
import src.parte1.utils.SortUtil;

public class Main {


    public static void main(String[] args) {
            Persona persona1 = new Persona("Juan", 100);
            Persona persona2 = new Persona("Juana", 101);
            Persona persona3 = new Persona("Juano", 99);
            Precedable<Persona>[] arr = new Precedable[3];
            arr[0] = persona1;
            arr[1] = persona2;
            arr[2] = persona3;
            SortUtil.ordenar(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].toString());
            }
            Celular cel1= new Celular(3135,"italo");
            Celular cel2= new Celular(3541,"italo2");
            Celular cel3= new Celular(3058,"italo1");

            Precedable<Celular>[] arr1 = new Precedable[3];
            arr1[0] = cel1;
            arr1[1] = cel2;
            arr1[2] = cel3;

            SortUtil.ordenar(arr1);
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i].toString());
            }
    }
}
