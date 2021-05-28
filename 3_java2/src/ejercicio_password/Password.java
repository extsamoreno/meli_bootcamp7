package ejercicio_password;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    protected String password;
    protected String regex;
    public Password (String regex ) {
        this.regex = regex;

    }
    public void setValue(String pwd) {
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(pwd);
        try {
            if (mat.matches()) {
                this.password = pwd;
                System.out.println("La contraseña se guardó exitosamente");
            } else {
                throw new Exception();
            }

        }
        catch (Exception ex) {
            System.out.println("La contraseña no cumple con los requisitos de la directiva de contraseñas");

        }

    }

}
