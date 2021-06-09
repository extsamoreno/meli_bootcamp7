package socialmeli.socialmeli.project.services.Dto.ProductDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import socialmeli.socialmeli.project.models.Product;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class PostDto {
    private Integer userId;
    private Integer idPost;
    private Date date;
    private Product detail;
    private Integer category;
    private Double price;
}
