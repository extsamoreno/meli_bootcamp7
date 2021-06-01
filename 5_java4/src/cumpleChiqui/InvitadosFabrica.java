package cumpleChiqui;

// Clase fabrica que crea invitados
public class InvitadosFabrica {

    public static Invitado crearInvitado(int type){
        switch(type){
            case 1:
                return new InvitadoMeli();
            case 2:
                return new InvitadoEstandar();
            default:
                return null;
        }


    }



}
