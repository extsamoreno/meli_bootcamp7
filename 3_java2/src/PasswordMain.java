public class PasswordMain {

    public static void main(String[] args) {

        //String regexFuerte = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{10,20}$";
        //String regexIntermedio = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,10}$";
        //String regexDebil = "^(?=.*[a-z]).{2,8}$";

        String passwordFuerteCorrecta = "ASD0912fgh!";
        String passwordItermediaCorrecta = "PaSsWoRd1";
        String passwordDebilCorrecta = "clave";

        String passwordFuerteIncorrecta = "ASD0912fgh";
        String passwordItermediaIncorrecta = "PaSsWoRd";
        String passwordDebilIncorrecta = "c";

        PasswordFuerte passwordFuerte = new PasswordFuerte();
        PasswordIntermedia passwordIntermedia = new PasswordIntermedia();
        PasswordSimple passwordSimple = new PasswordSimple();

        passwordFuerte.setValue(passwordFuerteCorrecta);
        passwordIntermedia.setValue(passwordItermediaCorrecta);
        passwordSimple.setValue(passwordDebilCorrecta);

        try {
            passwordFuerte.setValue(passwordFuerteIncorrecta);
        }catch (Exception ex) {
            System.out.println("Clave fuerte incorrecta");
        }

        try {
            passwordIntermedia.setValue(passwordItermediaIncorrecta);
        }catch (Exception ex) {
            System.out.println("Clave intermedia incorrecta");
        }

        try {
            passwordSimple.setValue(passwordDebilIncorrecta);
        }catch (Exception ex) {
            System.out.println("Clave debil incorrecta");
        }

    }
}
