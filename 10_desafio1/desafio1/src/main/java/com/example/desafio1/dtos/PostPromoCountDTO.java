package com.example.desafio1.dtos;

import com.example.desafio1.dtos.ReportDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostPromoCountDTO extends ReportDTO {
    private int promoproducts_count;
}
