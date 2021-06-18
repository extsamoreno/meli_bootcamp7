package com.desafio2.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class FileUtils {

    public static <T> void saveData(Set<T> set, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(filePath);
            objectMapper.writeValue(file, set);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

}
