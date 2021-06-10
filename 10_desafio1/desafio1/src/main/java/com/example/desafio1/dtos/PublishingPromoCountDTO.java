package com.example.desafio1.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublishingPromoCountDTO extends ReportDTO {
    private int promoproducts_count;
}
