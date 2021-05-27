package EjerciciosTarde1;

class MainPass{

    public static void main(String[]args) {

        String pass = "passsQsQ123";

        try{
            PasswordSimple passSimple = new PasswordSimple();
            passSimple.setValue(pass);
            System.out.println("Password Simple Valida");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            PasswordIntermedia passIntermedia = new PasswordIntermedia();
            passIntermedia.setValue(pass);
            System.out.println("Password Intermedia Valida");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            PasswordFuerte passFuerte = new PasswordFuerte();
            passFuerte.setValue(pass);
            System.out.println("Password Fuerte Valida");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
