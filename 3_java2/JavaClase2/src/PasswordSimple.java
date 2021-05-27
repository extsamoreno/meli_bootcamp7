public class PasswordSimple extends Password {

    public PasswordSimple(String pwd){
        String pat = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
        this.generatePass(pat, pwd);
    }
}