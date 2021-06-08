package project.Service.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsResponseDTO {
    private String name;
    private int gramms;
    private float calories;
}
