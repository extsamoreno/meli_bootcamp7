public class Fraccion {

    // suma entre fracciones
    public static String sumar (String a, String b) {
        // las fracciones se ingresan como una cadena
        // Ejemplo: 4/5 = "45"
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer numB = Integer.parseInt(String.valueOf(b.charAt(0))); // b
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // c
        Integer denB = Integer.parseInt(String.valueOf(b.charAt(1))); // d

        // suma de fracciones ->    a/b     +    c/d    = (a*d + b*c) / b*d
        String numerador = String.valueOf(numA * denB + numB * denA);
        String denominador = String.valueOf(denA * denB);

        return numerador + "/" + denominador;
    }

    // suma entre una fracción y un entero
    public static String sumar (String a, Integer b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // b

        // suma de fracción y entero -> a/b + c = (a + b*c) / b
        String numerador = String.valueOf(numA + b * denA);
        String denominador = String.valueOf(denA);

        return numerador + "/" + denominador;
    }

    // resta entre fracciones
    public static String restar (String a, String b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer numB = Integer.parseInt(String.valueOf(b.charAt(0))); // b
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // c
        Integer denB = Integer.parseInt(String.valueOf(b.charAt(1))); // d

        // resta entre fracciones -> a/b - c/d = (a*d - b*c) / b*d
        String numerador = String.valueOf(numA * denB - numB * denA);
        String denominador = String.valueOf(denA * denB);

        return numerador + "/" + denominador;
    }

    // resta entre una fracción y un entero
    public static String restar (String a, Integer b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // b

        // resta entre fracción y entero -> a/b - c = (a - b*c) / b
        String numerador = String.valueOf(numA - b * denA);
        String denominador = String.valueOf(denA);

        return numerador + "/" + denominador;
    }

    // multiplicación entre fracciones
    public static String multiplicar (String a, String b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer numB = Integer.parseInt(String.valueOf(b.charAt(0))); // b
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // c
        Integer denB = Integer.parseInt(String.valueOf(b.charAt(1))); // d

        // multiplicación de fracciones -> numA/denA * numB/denB = numA*numB / denA*denB
        String numerador = String.valueOf(numA * numB);
        String denominador = String.valueOf(denA * denB);

        return numerador + "/" + denominador;
    }

    // multiplicación entre una fracción y un entero
    public static String multiplicar (String a, Integer b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // b

        // multiplicación entre una fracción y un entero -> a/b * c = a*c / b

        String numerador = String.valueOf(numA * b);
        String denominador = String.valueOf(denA);

        return numerador + "/" + denominador;
    }

    // división entre fracciones
    public static String dividir (String a, String b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer numB = Integer.parseInt(String.valueOf(b.charAt(0))); // b
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // c
        Integer denB = Integer.parseInt(String.valueOf(b.charAt(1))); // d

        // división entre fracciones -> a/b / c/d = a*d / b*c
        String numerador = String.valueOf(numA * denB);
        String denominador = String.valueOf(denA * numB);

        return numerador + "/" + denominador;
    }

    // división entre una fracción y un entero
    public static String dividir (String a, Integer b) {
        Integer numA = Integer.parseInt(String.valueOf(a.charAt(0))); // a
        Integer denA = Integer.parseInt(String.valueOf(a.charAt(1))); // b

        // división entre fracción y entero -> a/b / c = a / b*c
        String numerador = String.valueOf(numA);
        String denominador = String.valueOf(denA * b);

        return numerador + "/" + denominador;
    }
}


