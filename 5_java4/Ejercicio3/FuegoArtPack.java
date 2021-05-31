import java.util.ArrayList;

public class FuegoArtPack  implements IFuegoArtifical{
    ArrayList<IFuegoArtifical> fuegos;

    public FuegoArtPack(ArrayList<IFuegoArtifical> fuegos) {
        this.fuegos = fuegos;
    }

    @Override
    public void explotar() {
        for (IFuegoArtifical fuego: fuegos){
            fuego.explotar();
        }
    }
}
