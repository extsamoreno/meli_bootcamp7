package muelitas1.demo.service;

import lombok.AllArgsConstructor;
import muelitas1.demo.model.DTO.DentistDTOCreate;
import muelitas1.demo.model.DTO.DentistDTORead;
import muelitas1.demo.model.DTO.DentistDTOUpdate;
import muelitas1.demo.model.Dentist;
import muelitas1.demo.repository.IDentistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{
    IDentistRepository iDentistRepository;
    ModelMapper modelMapper;

    @Override
    public List<DentistDTORead> getDentists() {
        return iDentistRepository.findAll().stream()
                .map(dentist -> modelMapper.map(dentist, DentistDTORead.class))
                .collect(Collectors.toList());
    }

    @Override
    public DentistDTORead createDentist(DentistDTOCreate dentistDTOCreate) {
        var newDentist = iDentistRepository.save(modelMapper.map(dentistDTOCreate, Dentist.class));
        return modelMapper.map(newDentist, DentistDTORead.class);
    }

    @Override
    public DentistDTORead updateDentist(DentistDTOUpdate dentistDTOUpdate) {
        var newDentist = iDentistRepository.save(modelMapper.map(dentistDTOUpdate, Dentist.class));
        return modelMapper.map(newDentist, DentistDTORead.class);
    }

    @Override
    public void deleteDentist(long id) {
        iDentistRepository.deleteById(id);
    }
}
