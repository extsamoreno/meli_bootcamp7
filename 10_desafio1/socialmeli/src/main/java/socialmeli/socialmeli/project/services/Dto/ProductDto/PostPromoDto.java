package socialmeli.socialmeli.project.services.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostPromoDto {
    private Integer userId;
    private String userName;
    private Integer promoproducts_count;

}
