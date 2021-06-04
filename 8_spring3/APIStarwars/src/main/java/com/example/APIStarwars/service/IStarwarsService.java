package com.example.APIStarwars.service;

import com.example.APIStarwars.service.dto.SubjectDTO;

import java.util.List;

public interface IStarwarsService {
    List<SubjectDTO> getSubject(String name);
}
