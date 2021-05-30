package TT.Exercise1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        PasswordSimple simple = new PasswordSimple("^[a-z]+$");
        try {
            simple.setValue("hola");
        }
        catch (Exception ex){
            System.out.println("Error en simple");
        }
        PasswordIntermedia inter = new PasswordIntermedia("^[a-z]+$");
        try {
            inter.setValue("hola1");
            System.out.println("Inter OK");
        }
        catch (Exception ex){
            System.out.println("Error en inter");
        }
        PasswordFuerte fuerte = new PasswordFuerte("^[a-zA-Z0-9]+$");
        try {
            fuerte.setValue("hola");
        }
        catch (Exception ex){
            System.out.println("Error en fuerte");
        }
    }
}

