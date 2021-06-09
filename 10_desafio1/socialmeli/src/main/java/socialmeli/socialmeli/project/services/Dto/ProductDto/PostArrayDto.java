package socialmeli.socialmeli.project.services.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialmeli.socialmeli.project.models.Post;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostArrayDto {
    ArrayList<Post> postDtoList = new ArrayList<>();
}
