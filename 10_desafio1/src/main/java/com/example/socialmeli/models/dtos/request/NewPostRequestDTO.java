package com.example.socialmeli.models.dtos.request;

import com.example.socialmeli.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Data
public class NewPostRequestDTO {
    private int userId;
    private int postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
}
