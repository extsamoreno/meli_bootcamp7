package sql.imple.services.dentist;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sql.imple.models.Dentist;
import sql.imple.repositories.IDentistRepository;
import sql.imple.models.dto.DentistDTO;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {

    IDentistRepository iDentistRepository;
    ModelMapper mapper;

    @Override
    public void createDentist(DentistDTO dentistDTO) {
        iDentistRepository.save(mapper.map(dentistDTO,Dentist.class));
    }

    @Override
    public void deleteDentistById(Long id) {
        iDentistRepository.deleteById(id);
    }

    @Override
    public void updateDentist(DentistDTO dentistDTO) {
        iDentistRepository.save(mapper.map(dentistDTO,Dentist.class));
    }

    @Override
    public List<DentistDTO> findAllDentists() {
        List<Dentist> dentists = iDentistRepository.findAll();
        return dentists.stream().map(dentist -> mapper.map(dentist, DentistDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DentistDTO findDentistById(Long id) {
        Optional<Dentist> item = iDentistRepository.findById(id);
        return item.map(dentist -> mapper.map(dentist, DentistDTO.class)).orElse(null);
    }
}
