package desafio1.demo.Model.DTO;

import desafio1.demo.Model.Entity.Product;
import lombok.Data;

import java.util.Date;

@Data
public class NewPostRequestDTO {
    int userId;
    int id_post;
    String date;
    Product detail;
    int category;
    double price;
}
