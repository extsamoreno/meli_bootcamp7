package com.muelitas.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {

    private Long id;

    private String name;

    public StatusDTO(Long id) {
        this.id = id;
    }
}
