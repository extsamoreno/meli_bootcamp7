package com.example.demo.DTO;

import com.sun.jdi.PrimitiveValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCountPromosDTO {

    private int userId;
    private String userName;
    private int promoProducts_count;
}
