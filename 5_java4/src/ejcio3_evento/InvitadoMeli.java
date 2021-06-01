package ejcio3_evento;

public class InvitadoMeli extends Invitado{

    public InvitadoMeli(String id) {
        super(id);
    }

    @Override
    public void comer() {
        System.out.println("(invitado Meli comiendo)... Viva la Chiqui!!!");
    }
}
