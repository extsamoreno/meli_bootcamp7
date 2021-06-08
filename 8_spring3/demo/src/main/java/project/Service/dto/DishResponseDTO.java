package project.Service.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class DishResponseDTO {
    private String name;
    private List<IngredientsRequestDTO> Ingridients;
}
