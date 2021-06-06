package CumpleChiqui;

public class InvitadoMeli extends Invitado {
    private int nroEmpleado;

    public InvitadoMeli(int nroEmpleado, String nombre) {
        super(nombre);
        this.nroEmpleado = nroEmpleado;
    }

    @Override
    public void alabar() {
        System.out.println("Viva la Chiqui!");
    }
}
