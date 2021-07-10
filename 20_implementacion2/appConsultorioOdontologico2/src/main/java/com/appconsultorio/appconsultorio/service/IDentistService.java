package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.DentistDTO;
import com.appconsultorio.appconsultorio.model.Dentist;

import java.time.LocalDateTime;
import java.util.List;

public interface IDentistService {
    void createDentist(DentistDTO dentistDTO);
    void updateDentist(DentistDTO dentistDTO);
    void removeDentist(int id);
    List<Dentist> getDentist() ;
    List<Dentist> findDentistWithMoreOf2Turns(LocalDateTime date);
}
