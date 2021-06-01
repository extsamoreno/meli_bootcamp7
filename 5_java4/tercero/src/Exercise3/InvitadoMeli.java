package Exercise3;

public class InvitadoMeli extends Invitado{
    @Override
    public void comer() {
        System.out.println("VIVA LA CHIQUI");
    }
    public InvitadoMeli(String id){
        super(id);
    }
}
