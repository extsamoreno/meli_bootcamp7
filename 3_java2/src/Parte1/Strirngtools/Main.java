package Parte1.Strirngtools;


public class Main {

    public static void main(String[] args) {
        String rpad = StringUtil.rpad("Hola", '!', 10);
        System.out.println(rpad);
        String ltrim = StringUtil.ltrim("       Hola       ");
        System.out.println(ltrim);
        String dtrim = StringUtil.rtrim(ltrim);
        System.out.println(ltrim);
        String JhonPaul  = "John|Paul|George|Ringo";
        System.out.println(StringUtil.indexOfN(JhonPaul, '|', 3));
    }
}
