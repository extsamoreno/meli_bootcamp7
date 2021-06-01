package ejcio3_evento;

public class InvitadoStandard extends Invitado {

    public InvitadoStandard(String id) {
        super(id);
    }

    @Override
    public void comer() {
        System.out.println("(invitado standard comiendo... en silencio)");
    }
}
