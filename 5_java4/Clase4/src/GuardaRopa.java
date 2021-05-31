import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendas;
    private int contador ;

    public GuardaRopa(){

        this.contador = 0;
        this.prendas = new HashMap<Integer, List<Prenda>>();
    }


    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        prendas.put(this.contador, listaDePrenda);

        this.contador++;

        return this.contador-1;
    }

    public void mostrarPrendas(){

        this.prendas.forEach(
            (k, v) -> System.out.println("posicion : " + k + ", Prendas : " + v.toString())

            );
    }

    public List<Prenda> devolverPrendas(Integer numero){

        return prendas.remove(numero);
    }

}
