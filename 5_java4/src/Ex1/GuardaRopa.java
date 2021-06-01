package Ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int id;
    private Map<Integer, List<Prenda>> dic;
    private int cantidad;

    public GuardaRopa(int id) {
        this.id = id;
        this.dic = new HashMap<>();
        this.cantidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, List<Prenda>> getDic() {
        return dic;
    }

    public void setDic(Map<Integer, List<Prenda>> dic) {
        this.dic = dic;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        int res = this.cantidad + 1;
        this.dic.put(res, new ArrayList<>());
        for (Prenda prenda : listaDePrenda) {
            this.dic.get(res).add(prenda);
        }
        return res;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> prendas: this.dic.entrySet()){
            System.out.println("Bajo la clave : " + prendas.getKey() + "se encuentran las prendas :");
            for(Prenda p : prendas.getValue()){
                System.out.println(p);
            }

        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> res;
        try {
            res = this.dic.get(numero);
        }catch (Exception e){
            System.out.println("No se puede obtener las prendas bajo la clave " + numero);
            System.out.println(e);
            res = new ArrayList<>();
        }
        return res;
    }

}
