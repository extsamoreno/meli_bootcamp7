package meli.social.service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class UserErrorDTO {
    private String message;
    private String name;
}
