package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.DentistDTO;
import com.appconsultorio.appconsultorio.model.Dentist;

import java.util.List;

public interface IDentistService {
    public void createDentist(DentistDTO dentistDTO);
    public void updateDentist(DentistDTO dentistDTO);
    public void removeDentist(int id);
    public List<Dentist> getDentist() ;
}
