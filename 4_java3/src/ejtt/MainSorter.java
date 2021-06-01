package ejtt;
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

  }
  public static <T> void mostrarArr(T arr[]) {
    System.out.println();
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] +  " ");
    }
  }
}
