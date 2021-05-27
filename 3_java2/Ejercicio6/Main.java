package Ejercicio6;

public class Main {
    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        System.out.println(StringUtil.rpad("5",3,'0'));
        System.out.println(StringUtil.ltrim("      Hola Mundo"));
        System.out.println(StringUtil.rtrim("    Hola Mundo   "));
        System.out.println(StringUtil.trim("     Ho___ga    "));
        System.out.println(StringUtil.indexOfN("John|Paul|George|Ringo", '|', 2));
    }
}
