package EjerciciosTarde1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String password;
    private String regex;

    public Password(String regex) {
        this.regex = regex;
    }

    // Setear contraseña
    public void setValue(String password) throws Exception{

        if(testRegex(password)){
            this.password = password;
        }else{
            throw new Exception("El password no cumple con las normas de seguridad");
        }
    }

    // Validar contraseña que cumpla con los requisitos del patron
    public boolean testRegex(String password){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}
