package Excercise3;

public class InvitadosMeli extends Invitados {

    public InvitadosMeli(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void comerTorta() {
        System.out.println("Viva la Chiqui");
    }
}
