package com.example.demo.repository;

import com.example.demo.DTO.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DataBase {

    public static List<UserDTO> LoadDataBase() {
        File file = null;
        String fuenteArchivo = "src/main/java/com/example/demo/repository/user.json";
        try {
            file = ResourceUtils.getFile(fuenteArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserDTO>> typeRef = new TypeReference<>() {};
        List<UserDTO> user = null;
        try {
            user = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
