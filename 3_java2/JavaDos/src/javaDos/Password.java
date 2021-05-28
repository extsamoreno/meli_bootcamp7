package javaDos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String value;
    private String regex;

    public Password(String regex){
        this.regex = regex;
    }

    public void setPwd(String value) {
        Pattern pat = Pattern.compile(this.regex);
        Matcher mat = pat.matcher(value);
        boolean flag = mat.find();
        try {
            if (flag){
                this.value = value;
                System.out.println("Contraseña creada con éxito: " + this.value);
            } else {
                throw new Exception("La contraseña no coincide con el nivel de seguridad");
            }}
            catch (Exception e) {
                System.out.println(e);
            }
        }
}
