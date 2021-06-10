package com.example.desafio_1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoCountDTO extends UserDataBase{
    private int promoproducts_count;

    public PromoCountDTO(int userId, String userName, int promoproducts_count) {
        super(userId, userName);
        this.promoproducts_count = promoproducts_count;
    }
}
