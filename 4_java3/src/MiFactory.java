import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance (String objName){

        Object resultado = null;
        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileReader("src/MiFactory.properties"));
            String claveProperties = propiedades.getProperty(objName);
            resultado  = Class.forName(claveProperties).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[5];
        arr[0] = 65;
        arr[1] = 432;
        arr[2] = 5;
        arr[3] = 78;
        arr[4] = 175;

        QuickSortSorterImple prueba = new QuickSortSorterImple();
        Comparator<Integer> c1 = (a, b) ->  b-a;

        Sorter<Integer> sorter = (Sorter)MiFactory.getInstance("sorter");
        sorter.sort(arr, c1);

        for (int i = 0; i < arr.length-1 ; i++) {
            System.out.println(arr[i]);
        }
    }
}
