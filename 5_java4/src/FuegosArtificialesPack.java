import java.util.ArrayList;
import java.util.List;

public class FuegosArtificialesPack extends FuegosArtificiales{
    private List<FuegosArtificiales> listaFuegArt= new ArrayList<>();
    public FuegosArtificialesPack() {
    }

    /**
     * Este metodo agrega un fuego artificial o un pack de fuegos
     * artificiales aprovechando la herencia
     * @param x -> El fuego artificial individual o el pack a agregar
     */
    public void agregarFuegoArtificial(FuegosArtificiales x){
        listaFuegArt.add(x);
    }

    public void explotar(){
        for (int i = 0; i < listaFuegArt.size(); i++) {
            listaFuegArt.get(i).explotar();
        }
    }

    public List<FuegosArtificiales> getListaFuegArt() {
        return listaFuegArt;
    }

    public void setListaFuegArt(List<FuegosArtificiales> listaFuegArt) {
        this.listaFuegArt = listaFuegArt;
    }
}
