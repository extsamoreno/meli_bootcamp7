public class SocorristaMoto implements Socurrista<Moto>{

    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto "+moto.getPatente());
    }
    
}
