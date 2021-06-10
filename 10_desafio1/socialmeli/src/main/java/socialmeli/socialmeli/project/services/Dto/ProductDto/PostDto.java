package socialmeli.socialmeli.project.services.Dto.ProductDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.Product;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements Comparable<PostDto> {
    private Integer userId;
    private Integer idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private double discount;

    public PostDto(Integer userId, Integer idPost, Date date, Product detail, Integer category, Double price) {
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
    public int compareTo(PostDto o) {
        return getDate().compareTo(o.getDate());
    }
}
