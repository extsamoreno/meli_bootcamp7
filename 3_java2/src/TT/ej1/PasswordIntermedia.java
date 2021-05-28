package TT.ej1;

public class PasswordIntermedia extends Password {

    public PasswordIntermedia(String regex){
        Password(regex);
    }

    @Override
    public void Password(String regex){ //No tiene sentido que sobreescriba algo que se pasa como argumento, pero bueno queria usar clase abstracta
        regex = "^[a-z0-9_-]{3,15}$";
        this.regex = regex;
    }
}
