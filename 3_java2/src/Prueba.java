public class Prueba {

    public static void main(String[] args) {
            try{
                Password passs = new PasswordSimple();
                passs.setValue("123a654");
                System.out.println("OK PASS");

                Password pass = new passwordFuerte();
                pass.setValue("12*3Aa654");
                System.out.println("OK PASS");
            }catch (Exception e){
                System.out.println((e.getMessage()));
            }
    }
}
