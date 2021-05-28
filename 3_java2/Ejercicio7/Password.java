
package Ejercicio7;
import java.util.regex.*;
public class Password {

    private String pass;
    private String regex;

    public Password(String regex) {

        this.regex = regex;
    }

    public void setValue(String password) throws Exception{

        if(testRegex(password)){
            this.pass = password;
        }else{
            throw new Exception("El password no cumple con las normas de seguridad");
        }
    }

    //Validar cotraseña
    public boolean testRegex(String password){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
