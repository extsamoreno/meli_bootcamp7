import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password;
    private String regex;

    public Password() {
    }

    public Password (String regex) {
        this.regex = regex;
    }

    // getters
    public String obtenerExpresionRegular () {
        return this.regex;
    }

    public String obtenerPassword () {
        return this.password;
    }

    // setters
    public void establecerExpresionRegular (String regex) {
        this.regex = regex;
    }

    public void establecerPassword (String password) {
        this.password = password;
    }

    public void setValue (String pwd) {
       if (pwd.matches(regex)) {
           establecerPassword(regex);
           System.out.println("Contraseña generada exitosamente");
       } else {
           throw new SecurityException("La contraseña incumple los requerimientos");
       }
    }
}