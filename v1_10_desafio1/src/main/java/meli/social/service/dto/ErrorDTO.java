package meli.social.service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class ErrorDTO {
    private String message;
    private String name;
}
