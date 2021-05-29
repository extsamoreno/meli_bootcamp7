import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Password {
    String expresion;
    String valor;
    public Password() {
    }

    public Password(String expresion) {
        this.expresion = expresion;
    }

    public void setValue(String pvalor) throws Exception
    {
        Pattern pattern = Pattern.compile(this.expresion);
        Matcher matcher = pattern.matcher(pvalor);
        if(matcher.matches()){
        this.valor = pvalor;
        }
        else
        {
            throw new Exception("Password no cumple requisitos");
        }

    }



}