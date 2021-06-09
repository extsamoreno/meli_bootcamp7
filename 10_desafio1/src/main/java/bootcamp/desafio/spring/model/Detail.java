package bootcamp.desafio.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail{

    private Long product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
