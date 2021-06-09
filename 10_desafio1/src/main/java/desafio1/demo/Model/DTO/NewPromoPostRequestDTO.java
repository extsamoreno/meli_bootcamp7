package desafio1.demo.Model.DTO;

import desafio1.demo.Model.Entity.Product;
import lombok.Data;

@Data
public class NewPromoPostRequestDTO {
    int userId;
    int id_post;
    String date;
    Product detail;
    int category;
    double price;
    boolean hasPromo = false;
    double discount = 0;
}
