package ejtt;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class MainSorter {
  public static void main(String[] args) throws Exception{
    Sorter<Integer> iSorter = (Sorter<Integer>) MiFactory.getInstance("sorter");
    Sorter<String> sSorter = (Sorter<String>) MiFactory.getInstance("sorter");

    Integer[] iArr = {1, 233, 41, 31, 121, 24, 2, 87, 18, 12};
    Comparator<Integer> iComp = (a,b) -> a-b;
    mostrarArr(iArr);
    iSorter.sort(iArr, iComp);
    mostrarArr(iArr);

    String[] sArr = {"Juan", "Carlos", "Pedro", "De", "La", "Mar", "Es", "Mi", "Nombre", "Así"};
    Comparator<String> sComp = (a,b) -> a.compareTo(b);
    mostrarArr(sArr);
    sSorter.sort(sArr, sComp);
    mostrarArr(sArr);

    Time timer = new Time();
    Integer[] arrInt = crearIntArr();

    // Bubble Sort demoró: 29631 milisegundos.
    // Heap Sort demoró: 49 milisegundos.
    // Quick Sort demoró: 16 milisegundos.
    timer.startTime();
    iSorter.sort(arrInt, iComp);
    timer.stopTime();
    System.out.println("");
    System.out.println("------------------------------------------------------------");
    System.out.println("Tardó: " + timer.elapsedTime() + " milisegundos en ordenarse");
    System.out.println("------------------------------------------------------------");
    //mostrarArr(arrInt);

  }

  public static <T> void mostrarArr(T arr[]) {
    System.out.println();
    for (T elem: arr) {
      System.out.print(elem + " ");
    }
  }

  public static Integer[] crearIntArr() {
    Integer[] arrInt = new Integer[100000];
    for (int i = 99999; i >= 0 ; i--) {
      arrInt[arrInt.length - 1 - i] = i;
    }
    return arrInt;
  }
}
