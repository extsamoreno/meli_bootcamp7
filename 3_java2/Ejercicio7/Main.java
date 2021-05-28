package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        String pass = "0sc4r5320";

        try{
            PasswordSimple passSimple = new PasswordSimple();
            passSimple.setValue(pass);
            System.out.println("Password Simple Valida");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            PasswordIntermedio passIntermedia = new PasswordIntermedio();
            passIntermedia.setValue(pass);
            System.out.println("Password Intermedia Valida");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            PasswordFuerte passFuerte = new PasswordFuerte();
            passFuerte.setValue(pass);
            System.out.println("Password Fuerte Valida");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
