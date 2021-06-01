package Ejercicio3;

public class InvitadosMeli extends Invitados{
    public InvitadosMeli(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public void comerTorta() {
        super.comerTorta();
        System.out.println("Viva la Chiqui");
    }
}
