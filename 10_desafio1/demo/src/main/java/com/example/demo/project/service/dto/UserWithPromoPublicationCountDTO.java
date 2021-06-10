package com.example.demo.project.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class UserWithPromoPublicationCountDTO extends UserDTO {
    private int promoproducts_count;

    public UserWithPromoPublicationCountDTO(String name, int id, int promoproducts_count) {
        super(name, id);
        this.promoproducts_count = promoproducts_count;
    }
}
