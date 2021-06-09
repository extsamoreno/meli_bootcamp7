package com.example.demo.project.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class UserWithPromoPublicationCountDTO extends UserDTO {
    private int publicproducts_count;

    public UserWithPromoPublicationCountDTO(String name, int id, int publicproducts_count) {
        super(name, id);
        this.publicproducts_count = publicproducts_count;
    }
}
