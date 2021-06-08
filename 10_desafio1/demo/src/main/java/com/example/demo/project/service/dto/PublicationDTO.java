package com.example.demo.project.service.dto;

import com.example.demo.project.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO {
    private int id_post, id_user;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private String category;
    private float price;
}
