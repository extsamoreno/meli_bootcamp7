package project.Service.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class DishResponse {
    private String name;
    private List<IngredientsResponse> ingridients;
}
