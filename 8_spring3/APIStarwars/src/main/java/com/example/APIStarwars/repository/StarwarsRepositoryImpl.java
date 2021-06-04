package com.example.APIStarwars.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarwarsRepositoryImpl implements IStarwarsRepository{
    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjectList= loadDataBase();
        return subjectList;
    }
    private List<Subject> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<Subject>> typeDef = new TypeReference<>(){};
        List<Subject> subjectList = null;
        try{
            subjectList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return subjectList;
    }
}
