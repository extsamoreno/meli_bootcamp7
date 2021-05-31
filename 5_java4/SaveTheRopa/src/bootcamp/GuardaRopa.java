package bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private int count;
    private HashMap<Integer, List<Prenda>> items = new HashMap<>();

    public GuardaRopa() {
        this.count = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.count++;
        items.put(count, listaDePrenda);
        return count;
    }

    public List<Prenda>  devolverPrendas(Integer num){
        this.count++;
        items.put(count, listaDePrenda);
        return count;
    }


    public HashMap<Integer, List<Prenda>> getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
