package tarde;

public class TestPassword {
    public static void main(String[] args) {

        String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        PasswordFuerte pass = new PasswordFuerte(REGEX);
        System.out.println(pass.validatePass("jhhKK97jgh+"));
    }

}
