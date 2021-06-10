package socialmeli.socialmeli.project.services.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import socialmeli.socialmeli.project.models.Post;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class PostPromoListDto {
    ArrayList<Post> postPromoArr;
}
