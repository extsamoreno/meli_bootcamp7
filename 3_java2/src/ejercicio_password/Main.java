package ejercicio_password;

public class Main {
    public static void main(String[] args) {
        String regexPasswordSimple = "^(?=.*[0-9])"+ "(?=.*[a-z])" + "(?=\\S+$).{8,20}$";
        PasswordSimple ejemploSimple = new PasswordSimple(regexPasswordSimple);
        ejemploSimple.setValue("ejemplo1");
        ejemploSimple.setValue("ejemplo");

        String regexPasswordIntermedia = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])" + "(?=\\S+$).{8,20}$";
        PasswordIntermedia ejemploIntermedio = new PasswordIntermedia(regexPasswordIntermedia);
        ejemploIntermedio.setValue("Ejemplo1");
        ejemploIntermedio.setValue("ejemplo1");


        String regexPasswordFuerte = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])" + "(?=\\S+$).{8,20}$";
        PasswordFuerte ejemploFuerte = new PasswordFuerte(regexPasswordFuerte);
        ejemploFuerte.setValue("Ejemplo@1");
        ejemploFuerte.setValue("Ejemplo1");


    }

}
