public class Main {
    public static void main(String[] args) {
        String prueba = "John|Paul|George|Ringo";
        String prueba1 = "    La prueba de espacios    ";
        String prueba2 = "          ";
        System.out.println(StringUtil.indexOfN(prueba, '|', 4));
        System.out.println("Prueba de ltrim " + StringUtil.ltrim(prueba1));
        System.out.println("Prueba de rtrim " + StringUtil.rtrim(prueba1));
        System.out.println("Prueba de trim " + StringUtil.trim(prueba1));
        System.out.println("Prueba de ltrim " + StringUtil.ltrim(prueba2));
        System.out.println("Prueba de rtrim " + StringUtil.rtrim(prueba2));
        System.out.println("Prueba de trim " + StringUtil.trim(prueba2));
    }
}
