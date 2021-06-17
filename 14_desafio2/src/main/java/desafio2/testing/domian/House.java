package desafio2.testing.domian;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private int id;
    private String prop_name;
    private District district;
    private List<EnvironmentHouse> environments = new ArrayList<>();

    /*public House() {
        this.environments = new ArrayList<>();
    }*/
}
