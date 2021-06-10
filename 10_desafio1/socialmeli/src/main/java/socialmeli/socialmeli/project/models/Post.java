package socialmeli.socialmeli.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class Post implements Comparable<Post>{
        private Integer userId;
        private Integer idPost;
        @JsonFormat(pattern="dd-MM-yyyy")
        private Date date;
        private Product detail;
        private Integer category;
        private Double price;
        private boolean hasPromo;
        private double discount;

    public Post(Integer userId, Integer idPost, Date date, Product detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo=false;
        this.discount=0;
    }

    @Override
    public int compareTo(Post o) {
        return getDate().compareTo(o.getDate());
        }
    }
