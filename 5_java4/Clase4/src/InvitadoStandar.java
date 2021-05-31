import java.util.List;

public class InvitadoStandar extends Invitado{
    
    public InvitadoStandar(String nombre, int edad){

        super(nombre, edad);
    }

    public void encenderFuegosArtificiales(List <FuegoArtificial> fuegosArtificialesa){

        for (int i = 0; i < fuegosArtificialesa.size(); i++) {

            fuegosArtificialesa.get(i).explotar();
            
        }
    }
}
