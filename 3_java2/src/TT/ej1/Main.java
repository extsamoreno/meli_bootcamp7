package TT.ej1;

public class Main {
    public static void main(String[] args){
        //System.out.println("Esto sale en pantalla\n");
        //TM.CuentaCorriente cuenta = new TM.CuentaCorriente();

        System.out.println("Esto sale en pantalla\n");
        Password pass = new PasswordSimple("");
        try{
            pass.setValue("2");
        }catch(Exception e){
            System.out.println("Se produjo una excepcion");
        }

    }
}
