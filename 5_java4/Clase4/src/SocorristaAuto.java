public class SocorristaAuto implements Socurrista<Auto>{

    public void socorrer(Auto auto){
        System.out.println("Socorriendo auto "+auto.getPatente());
    }
    
}
