package com.example.APIStarwars.service;

import com.example.APIStarwars.repository.IStarwarsRepository;
import com.example.APIStarwars.repository.Subject;
import com.example.APIStarwars.service.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class StarwarsServiceImp implements IStarwarsService{
    @Autowired
    IStarwarsRepository iStarwarsRepository;


    @Override
    public List<SubjectDTO> getSubject(String name) {
        List<Subject> subjectList = iStarwarsRepository.getAllSubjects();
        System.out.println(subjectList);
        List<SubjectDTO> resultList = new ArrayList<>();

        for(Subject subject : subjectList){
            if(subject.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))){
                resultList.add(new SubjectDTO(subject.getName()));
            }
        }

        return resultList;
    }
}
