package meli.springchallenge.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.springchallenge.dtos.ProductDTO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;
    private int postId;
    private Date date;
    private int productId;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(int userId, int postId, Date date, int productId, int category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.productId = productId;
        this.category = category;
        this.price = price;
    }
}