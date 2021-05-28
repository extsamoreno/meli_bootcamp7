import ejercicio1.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Ejercicio Password
        PasswordSimple pwd1 = new PasswordSimple();
        pwd1.setValue("soyunpassword");

        //PasswordIntermedia pwd2 = new PasswordIntermedia();
        //pwd2.setValue("soyunpassword");

        PasswordFuerte pwd3 = new PasswordFuerte();
        pwd3.setValue("soyunpassword");
    }
}
