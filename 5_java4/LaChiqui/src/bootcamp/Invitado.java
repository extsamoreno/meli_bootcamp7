package bootcamp;

public class Invitado {

    private String name;
    private boolean esMeli;

    public Invitado(String name, boolean esMeli) {
        this.name = name;
        this.esMeli = esMeli;
    }

    public void alabarMirta(){
        if (esMeli){
            System.out.println("Viva la Chiqui!!!");
        }
        else{
            System.out.println("Como quisiera poder trabajar en Meli");
        }
    }
}
