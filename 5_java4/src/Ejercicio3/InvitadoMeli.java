package Ejercicio3;

public class InvitadoMeli implements IInvitado{
    private String name;

    @Override
    public void degustar() {
        System.out.println("Viva la Chiqui!!");
    }
}
