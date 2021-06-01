import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String regex;

    public Password(String regex) {
        this.regex = regex;
    }

    public void setValue(String pwd){
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(pwd);

        if(mat.find()){
            System.out.println("Contraseña asignada");
        }else{
            throw new IllegalArgumentException("La contraseña utilizada no cumple los criterios de aceptacion.");
        }

    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }


    public static void main(String[] args) {


        String regex = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,10}$";
        String passwordPCorrecta = "asdASD123!";
        String passwordMala = "asdASD123";


        Password password = new Password(regex);
        password.setValue(passwordPCorrecta);
        password.setValue(passwordMala);

    }
}
