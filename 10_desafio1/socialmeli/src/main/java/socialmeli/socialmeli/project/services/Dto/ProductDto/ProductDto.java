package socialmeli.socialmeli.project.services.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Integer producId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
