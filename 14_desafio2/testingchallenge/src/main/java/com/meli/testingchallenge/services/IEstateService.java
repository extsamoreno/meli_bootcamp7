package com.meli.testingchallenge.services;

import com.meli.testingchallenge.dtos.EstateAssessmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;

public interface IEstateService {

    public EstateAssessmentDTO getAssessment(EstateDTO estate);
}
