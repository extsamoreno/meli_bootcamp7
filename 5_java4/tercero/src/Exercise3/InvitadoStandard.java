package Exercise3;

public class InvitadoStandard extends Invitado{
    @Override
    public void comer() {
        System.out.println("callado");
    }
    public InvitadoStandard(String id){
        super(id);
    }
}
