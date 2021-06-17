package com.meli.testingchallenge.services;

import com.meli.testingchallenge.dtos.DistrictDTO;
import com.meli.testingchallenge.dtos.EstateAssessmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;
import com.meli.testingchallenge.exceptions.DistrictNotFoundException;
import com.meli.testingchallenge.exceptions.ExistentDistrictNameException;

public interface IEstateService {

    public EstateAssessmentDTO getAssessment(EstateDTO estate) throws DistrictNotFoundException;

    String addDistrict(DistrictDTO district) throws ExistentDistrictNameException;
}
