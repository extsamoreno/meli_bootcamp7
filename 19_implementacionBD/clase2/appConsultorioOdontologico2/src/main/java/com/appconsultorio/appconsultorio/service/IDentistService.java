package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Dentist;

import java.util.List;

public interface IDentistService {
    public void createDentist(Dentist dentist);
    public void updateDentist(Dentist dentist);
    public void removeDentist(int id);
    public List<Dentist> getDentist() ;
}
