package martegroupsa;

public class InvitadoMeli extends martegroupsa.Invitado {
    public InvitadoMeli(String nombre) {
        super(nombre);
    }

    @Override
    public void comerTorta(){
        System.out.println("Viva la Chiqui!!");
    }
}