package tm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejcio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese la cantidad de números naturales que quiera mostrar:");
        int n = scanner.nextInt();

        System.out.println("Ingrese un dígito que será el que aparezca en todos los números naturales mostrados:");
        int d = scanner.nextInt();

        System.out.println("Ingrese la cantidad de veces que este dígito vaya a aparecer en los números mostrados:");
        int m = scanner.nextInt();

        System.out.println(getNaturalNumbers(n, m, d));
    }

    public static List<String> getNaturalNumbers(int n, int m, int d) {
        List<String> myList = new ArrayList<>();
        StringBuilder myString = new StringBuilder(Integer.toString(d));

        myString.append(String.valueOf(d).repeat(Math.max(0, m - 1)));

        int counter = 0;

        for (int i = 0; counter < n; i++) {

            String thisNumber = Integer.toString(i);

            if (thisNumber.contains(myString.toString())) {
                myList.add(thisNumber);
                counter++;
            }
        }
        return myList;
    }
}
