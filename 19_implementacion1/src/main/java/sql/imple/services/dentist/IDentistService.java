package sql.imple.services.dentist;

import sql.imple.models.dto.DentistDTO;

import java.util.List;

public interface IDentistService {
    void createDentist(DentistDTO dentist);
    void deleteDentistById(Long id);
    void updateDentist(DentistDTO dentist);
    List<DentistDTO> findAllDentists();
    DentistDTO findDentistById(Long id);
}
