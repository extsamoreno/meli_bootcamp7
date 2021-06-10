package com.example.demo.project.service.dto;

import com.example.demo.project.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO {

    @NotNull(message="El 'post_id' es un campo requerido.")
    protected Integer post_id;
    @NotNull(message="El 'user_id' es un campo requerido.")
    protected Integer user_id;
    @NotNull(message="El 'date' es un campo requerido.")
    @JsonFormat(pattern="dd-MM-yyyy")
    protected LocalDate date;
    @NotNull(message="El 'detail' es requerido.")
    protected ProductDTO detail;
    @NotNull(message="El 'category' es un campo  requerido.")
    protected Integer category;
    @NotNull(message="El 'price' es un campo  requerido.")
    protected Double price;
}
