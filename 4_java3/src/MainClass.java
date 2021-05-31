import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;

public class MainClass {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        //ejercicioSortUtil();
        //ejercicioSortersPruebas();
        timeTest();
    }

    private static void timeTest() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Integer[] arr=generateDataTest(100000);
        Comparator<Integer> c1= (a,b)->b-a;
        Sorter sorter1= (Sorter) MiFactory.getInstance("");
        Time.start();
        sorter1.sort(arr,c1);
        Time.stop();
        System.out.println("Tiempo: "+Time.elapsedTime());
    }

    private static Integer[] generateDataTest(int n) {
        int N=n;
        ArrayList<Integer> dataTest=new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            dataTest.add((int) Math.ceil(Math.random()*10000));
        }
        return dataTest.toArray(new Integer[n]);
    }

    private static void ejercicioSortersPruebas() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Sorter sorter1= (Sorter) MiFactory.getInstance("");
        String[] arr= {"hola","mundo","viva","muerto","comida","aparato","hogar","laburo"};
        Integer[] arr2= {1,23,453,12343,212,3456,6785,98, 765,1,1,2};
        Comparator<String> c1= (a,b)->a.compareTo(b);
        Comparator<Integer> c2= (a,b)->a-b;
        System.out.println("\nantes de ordenar");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        sorter1.sort(arr,c1);
        System.out.println("\nDespues de ordenar");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nantes de ordenar");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
        sorter1.sort(arr2,c2);
        System.out.println("\nDespues de ordenar");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }

    private static void ejercicioSortUtil() {
        Persona[] lista= new Persona[6];
        lista[0]= new Persona("hola",1);
        lista[1]= new Persona("hola",3);
        lista[2]= new Persona("hola",5);
        lista[3]= new Persona("hola",2);
        lista[4]= new Persona("hola",6);
        lista[5]= new Persona("hola",4);

        System.out.println("\nAntes de ordenar: ");
        for (int i=0; i< lista.length;i++){
            System.out.print(lista[i].getDni()+" ");
        }
        System.out.println("\nDespues de ordenar: ");
        SortUtil.ordenar(lista);
        for (int i=0; i< lista.length;i++){
            System.out.print(lista[i].getDni()+" ");
        }

        Celular[] lista2= new Celular[6];
        lista2[0] = new Celular(1,"hola");
        lista2[1] = new Celular(3,"hola");
        lista2[2] = new Celular(5,"hola");
        lista2[3] = new Celular(2,"hola");
        lista2[4] = new Celular(6,"hola");
        lista2[5] = new Celular(4,"hola");
        System.out.println("\nAntes de ordenar: ");
        for (int i=0; i< lista2.length;i++){
            System.out.print(lista2[i].getNumero()+" ");
        }
        System.out.println("\nDespues de ordenar: ");
        SortUtil.ordenar(lista2);
        for (int i=0; i< lista2.length;i++){
            System.out.print(lista2[i].getNumero()+" ");
        }
    }
}
