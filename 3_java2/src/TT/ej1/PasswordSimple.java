package TT.ej1;

public class PasswordSimple extends Password {

    public PasswordSimple(String regex){
        Password(regex);
    }

    @Override
    public void Password(String regex){ //No tiene sentido que sobreescriba algo que se pasa como argumento, pero bueno queria usar clase abstracta
        regex = "[A-Z]";
        this.regex = regex;
    }
}
