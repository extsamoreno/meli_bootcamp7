package ejercicio7;

public class Main {
    public static void main(String[] args) {
        ejercicio7.Password password = new ejercicio7.Password("hola");
        try {
            password.setValue("");
            System.out.println("Password válida :)");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida :(");
        }

        ejercicio7.PasswordSimple passwordSimple = new ejercicio7.PasswordSimple();
        try {
            passwordSimple.setValue("gdfte85hj");
            System.out.println("Password válida :)");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida :(");
        }

        ejercicio7.PasswordIntermedia passwordIntermedia = new ejercicio7.PasswordIntermedia();
        try {
            passwordIntermedia.setValue("ghtgf89$%");
            System.out.println("Password válida :)");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida :(");
        }

        ejercicio7.PasswordFuerte passwordFuerte= new ejercicio7.PasswordFuerte();
        try {
            passwordFuerte.setValue("jhIU56?!");
            System.out.println("Password válida :)");
        } catch (IllegalArgumentException ex) {
            System.out.println("Password inválida :(");
        }
    }
}