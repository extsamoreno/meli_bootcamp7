import java.util.*;

public class GuardaRopa {
    Map<Integer, List<Prenda>> map = new HashMap<>();
    Integer cant = 1;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        map.put(cant,listaDePrenda);

        this.cant +=1;

        Integer k = getSingleKeyFromValue(map, listaDePrenda);
        return getSingleKeyFromValue(map, listaDePrenda);
    }

    public <Integer, Prenda> Integer getSingleKeyFromValue(Map<Integer, List<Prenda>> map, List<Prenda> value) {
        for (Map.Entry<Integer, List<Prenda>> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());

            for(Prenda prenda : entry.getValue()){
                System.out.println(prenda.toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return map.get(numero);
    }
}
