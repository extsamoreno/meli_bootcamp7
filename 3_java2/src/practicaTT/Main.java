package practicaTT;

public class Main {

    public static void main(String[] args) {
        Password pswd = new Password("aa");

        try {
            pswd.setValue("holaa");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordFuerte strong = new PasswordFuerte();

        try {
            strong.setValue("Ho?5asds");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordIntermedia medium = new PasswordIntermedia();

        try {
            medium.setValue("a1%asdert");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

        PasswordSimple weak = new PasswordSimple();

        try {
            weak.setValue("asdf1234");
            System.out.println("ok");
        } catch (IllegalArgumentException ex) {
            System.out.println("error " + ex.getMessage());
        }

    }
}
