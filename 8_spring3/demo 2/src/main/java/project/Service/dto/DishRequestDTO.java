package project.Service.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class DishRequestDTO {
    private String name;
    private List<IngredientsRequestDTO> ingridients;
}
