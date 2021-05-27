public class PasswordFuerte extends Password {

    public PasswordFuerte(String pwd) {
        String pat = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[–_?!*:&%+;=@.]).{8,20}$";
        this.generatePass(pat, pwd);
    }
}