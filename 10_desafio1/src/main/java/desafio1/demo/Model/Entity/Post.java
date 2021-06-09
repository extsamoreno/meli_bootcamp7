package desafio1.demo.Model.Entity;

import lombok.Data;

import java.time.LocalDate;

//Post and PromoPost share the same class, the property "hasPromo" is used to identify one from the other

@Data
public class Post {
    int userId;
    int id_post;
    LocalDate date;
    Product detail;
    int category;
    double price;
    boolean hasPromo = false;
    double discount = 0;
}
