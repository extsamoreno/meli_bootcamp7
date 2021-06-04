package project.Service.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsResponse {
    private String name;
    private int gramms;
    private float calories;
}
