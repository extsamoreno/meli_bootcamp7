public class InvitadoMeli extends Invitado{

    public InvitadoMeli(String nombre, int edad){

        super(nombre, edad);
    }

    public void comerTorta(){

        this.gritar();
    }

    public void gritar(){

        System.out.println("Viva la Chiqui!!");
    }
    
}
