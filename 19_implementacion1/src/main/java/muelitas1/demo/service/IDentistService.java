package muelitas1.demo.service;

import muelitas1.demo.model.DTO.DentistDTOCreate;
import muelitas1.demo.model.DTO.DentistDTORead;
import muelitas1.demo.model.DTO.DentistDTOUpdate;

import java.util.List;

public interface IDentistService {
    List<DentistDTORead> getDentists();
    DentistDTORead createDentist(DentistDTOCreate dentistDTOCreate);
    DentistDTORead updateDentist(DentistDTOUpdate dentistDTOUpdate);
    void deleteDentist(long id);
}
