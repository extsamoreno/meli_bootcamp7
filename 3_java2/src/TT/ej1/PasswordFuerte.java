package TT.ej1;

public class PasswordFuerte extends Password {

    public PasswordFuerte(String regex){
        Password(regex);
    }

    @Override
    public void Password(String regex){ //No tiene sentido que sobreescriba algo que se pasa como argumento, pero bueno, queria usar clase abstracta
        regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        this.regex = regex;
    }
}
