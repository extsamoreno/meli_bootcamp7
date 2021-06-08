package desafio1.desafio1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publications {
    private int userId;
    private String userName;
    private int id_post;
    private Date date;
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
