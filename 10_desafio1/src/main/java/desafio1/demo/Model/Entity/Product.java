package desafio1.demo.Model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    int product_id;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
