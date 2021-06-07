package com.example.demo.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCharacterDTO {
    private List<String> listOfCharacters = new ArrayList<>();
}