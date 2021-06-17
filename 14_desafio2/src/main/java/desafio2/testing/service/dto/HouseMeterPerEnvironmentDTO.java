package desafio2.testing.service.dto;

import lombok.*;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class HouseMeterPerEnvironmentDTO {
    private String prop_name;
    private HashMap<String, Double> meterPerEnvironment;

    public HouseMeterPerEnvironmentDTO() {
        this.meterPerEnvironment = new HashMap<>();
    }
}
