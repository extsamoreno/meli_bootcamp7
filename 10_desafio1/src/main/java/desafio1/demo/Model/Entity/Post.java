package desafio1.demo.Model.Entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {
    int userId;
    int id_post;
    LocalDate date;
    Product detail;
    int category;
    double price;
}
