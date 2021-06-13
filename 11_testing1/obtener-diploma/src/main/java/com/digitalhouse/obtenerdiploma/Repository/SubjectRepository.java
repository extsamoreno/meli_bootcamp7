package com.digitalhouse.obtenerdiploma.Repository;

import com.digitalhouse.obtenerdiploma.Repository.entities.Subject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class SubjectRepository implements ISubjectRepository {
    @Override
    public Subject getSubjectByname(String name) {
        List<Subject> SubjectList = loadDatabase();
        Subject result = null;
        if (SubjectList != null) {
            Optional<Subject> item = SubjectList.stream().filter(subject -> subject.getSubject().equals(name)).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }
    private List<Subject> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:SubjectList.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Subject>> typeRef = new TypeReference<>() {};
        List<Subject> ingrediente = null;
        try {
            ingrediente = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }
}
